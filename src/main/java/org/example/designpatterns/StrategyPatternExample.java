package org.example.designpatterns;

import java.math.BigDecimal;
import java.util.Map;

public final class StrategyPatternExample {
    private StrategyPatternExample() {
    }

    public static void main(String[] args) {
        FeeCalculator calculator = new FeeCalculator(Map.of(
                "NYSE", new EquityFeeStrategy(),
                "CME", new FuturesFeeStrategy()
        ));

        System.out.println("NYSE fee = " + calculator.calculate("NYSE", new Trade("AAPL", 100, new BigDecimal("185.25"))));
        System.out.println("CME fee = " + calculator.calculate("CME", new Trade("ESM6", 4, new BigDecimal("5250.50"))));
    }
}

record Trade(String symbol, int quantity, BigDecimal price) {
}

interface FeeStrategy {
    BigDecimal calculate(Trade trade);
}

final class EquityFeeStrategy implements FeeStrategy {
    @Override
    public BigDecimal calculate(Trade trade) {
        return trade.price().multiply(BigDecimal.valueOf(trade.quantity())).multiply(new BigDecimal("0.0005"));
    }
}

final class FuturesFeeStrategy implements FeeStrategy {
    @Override
    public BigDecimal calculate(Trade trade) {
        return BigDecimal.valueOf(trade.quantity()).multiply(new BigDecimal("1.20"));
    }
}

final class FeeCalculator {
    private final Map<String, FeeStrategy> strategies;

    FeeCalculator(Map<String, FeeStrategy> strategies) {
        this.strategies = strategies;
    }

    BigDecimal calculate(String venue, Trade trade) {
        FeeStrategy strategy = strategies.getOrDefault(venue, ignored -> BigDecimal.ZERO);
        return strategy.calculate(trade);
    }
}
