package org.example.threads;

import java.util.concurrent.CountDownLatch;

public final class LatchDemo {
    private LatchDemo() {
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        Runnable service = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println(name + " is initializing...");
                Thread.sleep(500);
                System.out.println(name + " is ready");
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();
            }
        };

        new Thread(service, "Database-Service").start();
        new Thread(service, "Cache-Service").start();
        new Thread(service, "Messaging-Service").start();

        System.out.println("Main system is waiting for dependencies...");
        latch.await();
        System.out.println("All dependencies are ready.");
    }
}
