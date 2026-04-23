package org.example.tradingsystemdesign;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Demonstrates a simplified in-memory order book.
 *
 * <p>A trading venue or internal matching component often maintains bid and ask price levels. A
 * production-grade order book is much more complex than this example, but the interview value here
 * is understanding the state transitions:
 *
 * <ul>
 *   <li>add or update a level</li>
 *   <li>remove empty levels</li>
 *   <li>derive best bid and best ask</li>
 *   <li>preserve the ordering of price levels</li>
 * </ul>
 *
 * <p>Trading-system interview angle:
 *
 * <ul>
 *   <li>bids are sorted descending</li>
 *   <li>asks are sorted ascending</li>
 *   <li>state must be deterministic and replayable</li>
 *   <li>sequence numbers matter in real feeds</li>
 * </ul>
 */
public final class OrderBookExample {
    private OrderBookExample() {
    }

    public static void main(String[] args) {
        SimpleOrderBook orderBook = new SimpleOrderBook();
        orderBook.update(Side.BUY, new BigDecimal("185.20"), 400);
        orderBook.update(Side.BUY, new BigDecimal("185.18"), 600);
        orderBook.update(Side.SELL, new BigDecimal("185.25"), 300);
        orderBook.update(Side.SELL, new BigDecimal("185.30"), 500);

        System.out.println("Best bid = " + orderBook.bestBid());
        System.out.println("Best ask = " + orderBook.bestAsk());

        orderBook.update(Side.SELL, new BigDecimal("185.25"), 0);
        System.out.println("Best ask after removal = " + orderBook.bestAsk());
    }
}

enum Side {
    BUY,
    SELL
}

final class SimpleOrderBook {
    private final NavigableMap<BigDecimal, Integer> bids = new TreeMap<>(Comparator.reverseOrder());
    private final NavigableMap<BigDecimal, Integer> asks = new TreeMap<>();

    /**
     * Adds, updates, or removes a price level.
     *
     * <p>Removing a level when quantity becomes zero is common in order-book maintenance logic.
     */
    void update(Side side, BigDecimal price, int quantity) {
        NavigableMap<BigDecimal, Integer> bookSide = side == Side.BUY ? bids : asks;
        if (quantity <= 0) {
            bookSide.remove(price);
            return;
        }
        bookSide.put(price, quantity);
    }

    PriceLevel bestBid() {
        return bids.isEmpty() ? null : new PriceLevel(bids.firstKey(), bids.firstEntry().getValue());
    }

    PriceLevel bestAsk() {
        return asks.isEmpty() ? null : new PriceLevel(asks.firstKey(), asks.firstEntry().getValue());
    }
}

record PriceLevel(BigDecimal price, int quantity) {
}
