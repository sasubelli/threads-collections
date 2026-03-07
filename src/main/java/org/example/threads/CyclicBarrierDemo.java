package org.example.threads;


import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        // A barrier for 3 threads with a task that runs when they all arrive
        CyclicBarrier barrier = new CyclicBarrier(3, () ->
                System.out.println("\n--- All threads arrived! Proceeding to next step ---\n")
        );

        Runnable worker = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println(name + " is working on Phase 1...");
                Thread.sleep(1000); // Simulate work

                // Wait for others
                barrier.await();

                System.out.println(name + " is starting Phase 2...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        new Thread(worker, "Thread-1").start();
        new Thread(worker, "Thread-2").start();
        new Thread(worker, "Thread-3").start();
        new Thread(worker, "Thread-4").start();
        new Thread(worker, "Thread-5").start();
        new Thread(worker, "Thread-6").start();
    }
}
