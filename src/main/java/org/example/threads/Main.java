package org.example.threads;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Active thread count before start = " + Thread.activeCount());

        Threadexample threadExample = new Threadexample();
        threadExample.setName("Extends-Thread");

        Thread runnableThread = new Thread(new Runnbleexample(), "Runnable-Thread");

        Demonthredexample daemonThread = new Demonthredexample();
        daemonThread.setName("Daemon-Thread");
        daemonThread.setDaemon(true);

        threadExample.start();
        runnableThread.start();
        daemonThread.start();

        threadExample.join();
        runnableThread.join();

        System.out.println("Active thread count after joins = " + Thread.activeCount());
    }
}
