package org.example.threads;

public class Runnbleexample implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Runnable started on " + Thread.currentThread().getName());
            Thread.sleep(250);
            System.out.println("Runnable completed on " + Thread.currentThread().getName());
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }
}
