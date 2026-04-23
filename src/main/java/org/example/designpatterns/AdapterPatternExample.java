package org.example.designpatterns;

public final class AdapterPatternExample {
    private AdapterPatternExample() {
    }

    public static void main(String[] args) {
        TradePublisher publisher = new ExchangeFixAdapter(new LegacyFixGateway());
        publisher.publish(new InternalOrder("ORD-1", "AAPL", 100));
    }
}

record InternalOrder(String orderId, String symbol, int quantity) {
}

interface TradePublisher {
    void publish(InternalOrder order);
}

final class LegacyFixGateway {
    void sendFixMessage(String message) {
        System.out.println("FIX gateway sent: " + message);
    }
}

final class ExchangeFixAdapter implements TradePublisher {
    private final LegacyFixGateway gateway;

    ExchangeFixAdapter(LegacyFixGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void publish(InternalOrder order) {
        String fixMessage = "35=D|11=%s|55=%s|38=%d".formatted(order.orderId(), order.symbol(), order.quantity());
        gateway.sendFixMessage(fixMessage);
    }
}
