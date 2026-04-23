package org.example.tradingsystemdesign;

import java.math.BigDecimal;
import java.util.List;

/**
 * Demonstrates pre-trade risk checks.
 *
 * <p>Before an order leaves the system, trading platforms usually enforce risk rules such as:
 *
 * <ul>
 *   <li>max order quantity</li>
 *   <li>max notional value</li>
 *   <li>allowed symbols or venues</li>
 *   <li>position limits</li>
 *   <li>kill switch or user/session disablement</li>
 * </ul>
 *
 * <p>Interview point: risk checks must be deterministic, auditable, and fast. In real systems,
 * there is often a hot path with a carefully controlled rule set and a separate slower path for
 * reporting, alerting, and investigation.
 */
public final class PreTradeRiskCheckExample {
    private PreTradeRiskCheckExample() {
    }

    public static void main(String[] args) {
        RiskEngine engine = new RiskEngine(List.of(
                new MaxQuantityRule(1_000),
                new MaxNotionalRule(new BigDecimal("200000")),
                new AllowedSymbolRule(List.of("AAPL", "MSFT", "NVDA"))
        ));

        OrderCandidate valid = new OrderCandidate("AAPL", Side.BUY, 500, new BigDecimal("185.20"));
        OrderCandidate invalid = new OrderCandidate("TSLA", Side.BUY, 2_000, new BigDecimal("190.10"));

        System.out.println(engine.evaluate(valid));
        System.out.println(engine.evaluate(invalid));
    }
}

record OrderCandidate(String symbol, Side side, int quantity, BigDecimal limitPrice) {
    BigDecimal notional() {
        return limitPrice.multiply(BigDecimal.valueOf(quantity));
    }
}

record RiskDecision(boolean accepted, String reason) {
}

interface RiskRule {
    RiskDecision apply(OrderCandidate order);
}

final class RiskEngine {
    private final List<RiskRule> rules;

    RiskEngine(List<RiskRule> rules) {
        this.rules = rules;
    }

    /**
     * Stops at the first failing rule.
     *
     * <p>This is a common pattern in risk engines because it keeps the hot path simple and makes
     * the rejection reason explicit.
     */
    RiskDecision evaluate(OrderCandidate order) {
        for (RiskRule rule : rules) {
            RiskDecision decision = rule.apply(order);
            if (!decision.accepted()) {
                return decision;
            }
        }
        return new RiskDecision(true, "Accepted");
    }
}

record MaxQuantityRule(int maxQuantity) implements RiskRule {
    @Override
    public RiskDecision apply(OrderCandidate order) {
        return order.quantity() <= maxQuantity
                ? new RiskDecision(true, "Accepted")
                : new RiskDecision(false, "Rejected: quantity exceeds max limit");
    }
}

record MaxNotionalRule(BigDecimal maxNotional) implements RiskRule {
    @Override
    public RiskDecision apply(OrderCandidate order) {
        return order.notional().compareTo(maxNotional) <= 0
                ? new RiskDecision(true, "Accepted")
                : new RiskDecision(false, "Rejected: notional exceeds max limit");
    }
}

record AllowedSymbolRule(List<String> allowedSymbols) implements RiskRule {
    @Override
    public RiskDecision apply(OrderCandidate order) {
        return allowedSymbols.contains(order.symbol())
                ? new RiskDecision(true, "Accepted")
                : new RiskDecision(false, "Rejected: symbol not enabled");
    }
}
