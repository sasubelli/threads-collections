package org.example.threads;

import java.util.concurrent.*;

public class VirtualThreads {


    static void main() throws InterruptedException, ExecutionException {
        Runnable task = () -> {
            System.out.println("Hello from a Virtual Thread!");
            System.out.println("Current Thread: " + Thread.currentThread());

        };
        Thread vThread = Thread.ofVirtual().start(task);
        vThread.join();
        //Thread.sleep(1000);

        Callable<Object> callable = new Callable<Object>() {
            public Object call() throws Exception {

                return "Hello from a Virtual Thread! from callable -----`";
            }
        };

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        Future<Double> future = executor.submit(() -> {
            // This is a Callable
            System.out.println("Hello from a Virtual Thread! this is callable ");
            return 10.456; //"Hello from a virtual thread";
        });

        Double result = future.get();
        System.out.println(result);
        executor.close();
    }
}
