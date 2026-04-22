package org.example.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public final class SemaphoreExample {
    private SemaphoreExample() {
    }

    public static void main(String[] args) {
        Semaphore connectionPool = new Semaphore(3);
        ExecutorService executor = Executors.newFixedThreadPool(6);

        for (int index = 1; index <= 6; index++) {
            int workerId = index;
            executor.execute(() -> {
                try {
                    System.out.println("Worker " + workerId + " waiting for permit");
                    connectionPool.acquire();
                    System.out.println("Worker " + workerId + " acquired permit");
                    Thread.sleep(400);
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                } finally {
                    System.out.println("Worker " + workerId + " released permit");
                    connectionPool.release();
                }
            });
        }

        executor.shutdown();
    }
}
