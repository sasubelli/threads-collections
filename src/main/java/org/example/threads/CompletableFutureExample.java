package org.example.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public final class CompletableFutureExample {
    private CompletableFutureExample() {
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "java")
                .thenApply(String::toUpperCase)
                .thenApply(value -> value + " interview")
                .exceptionally(error -> "fallback");

        System.out.println(future.get());
    }
}
