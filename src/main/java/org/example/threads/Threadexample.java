package org.example.threads;

public class Threadexample extends Thread {
    @Override
    public void run() {
        try {
            for (int index = 1; index <= 3; index++) {
                System.out.println(getName() + " iteration " + index);
                Thread.sleep(250);
            }
            System.out.println(getName() + " completed");
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }
}
