package org.example.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public final class CyclicBarrierDemo {
    private CyclicBarrierDemo() {
    }

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3,
                () -> System.out.println("--- All workers completed phase 1 ---"));

        Runnable worker = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println(name + " working on phase 1");
                Thread.sleep(300);
                barrier.await();
                System.out.println(name + " working on phase 2");
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            } catch (BrokenBarrierException exception) {
                System.out.println("Barrier broken: " + exception.getMessage());
            }
        };

        for (int index = 1; index <= 6; index++) {
            new Thread(worker, "Worker-" + index).start();
        }
    }
}
