package org.example.threads;


public class Main {
     static void main() throws InterruptedException {
        System.out.println("Active thread count"+Thread.activeCount());

        System.out.print("Hello and welcome!");
        Threadexample threadexample = new Threadexample();
        threadexample.setPriority(Thread.MAX_PRIORITY);
        threadexample.start();

        //Runnable Example.
        Runnbleexample runnbleexample = new Runnbleexample();
        Thread runnable = new Thread(runnbleexample);
        runnable.start();


        //Demon Thread Example.
        Demonthredexample demonthredexample = new Demonthredexample();
        //setting up demon thread.
        demonthredexample.setDaemon(true);
       demonthredexample.start();

        System.out.println("Active thread count"+Thread.activeCount());

        threadexample.join();
        runnable.join();
        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
        Thread.sleep(1000);
System.out.println("Active thread count"+Thread.activeCount());
       // demonthredexample.start();
    }
}