package org.example.tradingsystemdesign;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Demonstrates position aggregation and unrealized PnL.
 *
 * <p>Trading systems often need both real-time and end-of-day position views. A common interview
 * topic is separating:
 *
 * <ul>
 *   <li>fill ingestion</li>
 *   <li>position calculation</li>
 *   <li>average cost tracking</li>
 *   <li>realized vs unrealized PnL</li>
 * </ul>
 *
 * <p>This example keeps the math intentionally simple and focuses on long-only accumulation.
 */
public final class PositionAndPnlExample {
    private PositionAndPnlExample() {
    }

    public static void main(String[] args) {
        List<Fill> fills = List.of(
                new Fill("AAPL", 100, new BigDecimal("184.80")),
                new Fill("AAPL", 200, new BigDecimal("185.10")),
                new Fill("AAPL", 50, new BigDecimal("185.40"))
        );

        PositionSnapshot snapshot = calculatePosition(fills, new BigDecimal("186.00"));
        System.out.println(snapshot);
    }

    public static PositionSnapshot calculatePosition(List<Fill> fills, BigDecimal markPrice) {
        int totalQuantity = fills.stream().mapToInt(Fill::quantity).sum();
        BigDecimal totalCost = fills.stream()
                .map(fill -> fill.price().multiply(BigDecimal.valueOf(fill.quantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal averagePrice = totalCost.divide(BigDecimal.valueOf(totalQuantity), 4, RoundingMode.HALF_UP);
        BigDecimal unrealizedPnl = markPrice.subtract(averagePrice).multiply(BigDecimal.valueOf(totalQuantity));

        return new PositionSnapshot("AAPL", totalQuantity, averagePrice, markPrice, unrealizedPnl);
    }
}

record Fill(String symbol, int quantity, BigDecimal price) {
}

record PositionSnapshot(
        String symbol,
        int netQuantity,
        BigDecimal averagePrice,
        BigDecimal markPrice,
        BigDecimal unrealizedPnl) {
}
