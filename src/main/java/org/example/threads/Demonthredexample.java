package org.example.threads;

public class Demonthredexample extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("demon thread running" + this.getName());
            System.out.println(this);
        }
    }
}
