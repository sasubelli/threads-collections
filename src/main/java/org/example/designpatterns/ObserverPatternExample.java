package org.example.designpatterns;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class ObserverPatternExample {
    private ObserverPatternExample() {
    }

    public static void main(String[] args) {
        MarketDataPublisher publisher = new MarketDataPublisher();
        publisher.subscribe(update -> System.out.println("Risk engine received " + update));
        publisher.subscribe(update -> System.out.println("Pricing engine received " + update));

        publisher.publish(new PriceUpdate("AAPL", new BigDecimal("185.23")));
    }
}

record PriceUpdate(String symbol, BigDecimal price) {
}

interface MarketDataListener {
    void onPrice(PriceUpdate update);
}

final class MarketDataPublisher {
    private final List<MarketDataListener> listeners = new ArrayList<>();

    void subscribe(MarketDataListener listener) {
        listeners.add(listener);
    }

    void publish(PriceUpdate update) {
        listeners.forEach(listener -> listener.onPrice(update));
    }
}
