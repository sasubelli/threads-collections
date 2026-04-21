package org.example.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public final class VirtualThreads {
    private VirtualThreads() {
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Thread virtualThread = Thread.ofVirtual().start(() ->
                System.out.println("Hello from virtual thread: " + Thread.currentThread()));
        virtualThread.join();

        try (ExecutorService executor = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor()) {
            Callable<String> task = () -> "Callable executed on " + Thread.currentThread();
            Future<String> message = executor.submit(task);
            Future<Double> price = executor.submit(() -> 10.456);

            System.out.println(message.get());
            System.out.println("Price = " + price.get());
        }
    }
}
