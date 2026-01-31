package org.example.threads;

public class Runnbleexample implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Hello World! " + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("Runnable Thread details:   " + Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
