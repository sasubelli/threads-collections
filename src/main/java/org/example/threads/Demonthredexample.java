package org.example.threads;

public class Demonthredexample extends Thread {
    @Override
    public void run() {
        for (int index = 1; index <= 3; index++) {
            try {
                Thread.sleep(200);
                System.out.println("Daemon heartbeat from " + getName() + " #" + index);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
