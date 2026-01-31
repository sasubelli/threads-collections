package org.example.threads;

public class Threadexample extends Thread {
    @Override
    public void run() {
        try {
            int i = 0;
            while (i <= 4) {
                System.out.println(this.getName());
                Thread.sleep(1000);
                i++;
                System.out.println("Thread Example Class :   " + this);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.getName() + "\n execution completed.");
    }
}
