package org.example.threads;

import java.util.concurrent.CountDownLatch;

public class LatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // Initialize with a count of 3
        CountDownLatch latch = new CountDownLatch(3);

        // Create 3 worker threads
        Runnable service = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println(name + " is initializing...");
                Thread.sleep(1500); // Simulate startup time
                System.out.println(name + " is READY.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // Decrement the count
                latch.countDown();
            }
        };

        new Thread(service, "Database-Service").start();
        new Thread(service, "Cache-Service").start();
        new Thread(service, "Messaging-Service").start();

        System.out.println("Main-System is waiting for services...");

        // Main thread blocks here until count is 0
        latch.await();

        System.out.println("All services are up! MAIN-SYSTEM STARTED.");
    }

}
