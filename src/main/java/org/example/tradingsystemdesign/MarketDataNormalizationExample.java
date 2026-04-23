package org.example.tradingsystemdesign;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Demonstrates market data normalization.
 *
 * <p>In real trading systems, exchanges and vendors often send different payload shapes, field
 * names, timestamp formats, symbol conventions, and precision rules. A normalization layer
 * converts those heterogeneous messages into one internal event model so downstream pricing,
 * analytics, order routing, and risk systems can operate consistently.
 *
 * <p>Key interview points:
 *
 * <ul>
 *   <li>normalize as early as possible</li>
 *   <li>preserve source venue and raw values for audit/debugging</li>
 *   <li>keep the internal event immutable</li>
 *   <li>be careful with price precision and timestamp ordering</li>
 * </ul>
 */
public final class MarketDataNormalizationExample {
    private MarketDataNormalizationExample() {
    }

    public static void main(String[] args) {
        ExchangeTick rawTick = new ExchangeTick("XNYS", "AAPL.O", "185.2300", "250", 1713881000123L);
        NormalizedQuote normalized = normalize(rawTick);
        System.out.println(normalized);
    }

    /**
     * Converts a venue-specific tick into a stable internal quote event.
     */
    public static NormalizedQuote normalize(ExchangeTick tick) {
        return new NormalizedQuote(
                normalizeSymbol(tick.symbol()),
                tick.venue(),
                new BigDecimal(tick.price()),
                Integer.parseInt(tick.size()),
                Instant.ofEpochMilli(tick.epochMillis()));
    }

    private static String normalizeSymbol(String venueSymbol) {
        return venueSymbol.replace(".O", "");
    }
}

record ExchangeTick(String venue, String symbol, String price, String size, long epochMillis) {
}

record NormalizedQuote(String symbol, String venue, BigDecimal price, int size, Instant eventTime) {
}
