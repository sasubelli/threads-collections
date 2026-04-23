package org.example.designpatterns;

public final class DecoratorPatternExample {
    private DecoratorPatternExample() {
    }

    public static void main(String[] args) {
        OrderExecutor executor = new MetricsOrderExecutor(new LoggingOrderExecutor(new BasicOrderExecutor()));
        executor.execute("BUY 100 AAPL @ 185.40");
    }
}

interface OrderExecutor {
    void execute(String order);
}

final class BasicOrderExecutor implements OrderExecutor {
    @Override
    public void execute(String order) {
        System.out.println("Executing order: " + order);
    }
}

final class LoggingOrderExecutor implements OrderExecutor {
    private final OrderExecutor delegate;

    LoggingOrderExecutor(OrderExecutor delegate) {
        this.delegate = delegate;
    }

    @Override
    public void execute(String order) {
        System.out.println("LOG: received order");
        delegate.execute(order);
    }
}

final class MetricsOrderExecutor implements OrderExecutor {
    private final OrderExecutor delegate;

    MetricsOrderExecutor(OrderExecutor delegate) {
        this.delegate = delegate;
    }

    @Override
    public void execute(String order) {
        long start = System.nanoTime();
        delegate.execute(order);
        long end = System.nanoTime();
        System.out.println("METRICS: execution took " + (end - start) + " ns");
    }
}
