package org.example.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        // 1. Initialize with 3 permits.
        // Only 3 threads can enter the "critical section" at once.
        Semaphore connectionPool = new Semaphore(3);

        ExecutorService executor = Executors.newFixedThreadPool(6);

        // Simulate 6 threads trying to access the 3 available slots
        for (int i = 1; i <= 6; i++) {
            int threadId = i;
            executor.execute(() -> {
                try {
                    System.out.println("Thread " + threadId + " is waiting for a permit...");

                    // 2. Acquire a permit (blocks if none are available)
                    connectionPool.acquire();

                    System.out.println(">>> Thread " + threadId + " ACQUIRED a permit. Working...");
                    Thread.sleep(2000); // Simulate database operation

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    // 3. ALWAYS release the permit in a finally block
                    System.out.println("<<< Thread " + threadId + " RELEASING permit.");
                    connectionPool.release();
                }
            });
        }
        executor.shutdown();
    }
}
