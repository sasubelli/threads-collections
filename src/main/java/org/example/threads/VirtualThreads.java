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

        Callable<String> call1 = new Callable<String>() {
            public String call() throws Exception {

                return "Hello from a Virtual Thread! from callable -----`";
            }
        };

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        Future<String> stringFuture = Executors.newVirtualThreadPerTaskExecutor().submit(call1);
        System.out.println(stringFuture.get() + " waiting for string future of callable");
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
