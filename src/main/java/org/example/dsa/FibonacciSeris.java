package org.example.dsa;

public final class FibonacciSeris {
    private FibonacciSeris() {
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci sequence up to 10 terms:");
        for (int index = 0; index <= 10; index++) {
            System.out.printf("fib(%d) = %d%n", index, fibonacci(index));
            System.out.println(FibonacciSeris.fibonacci_recursion(index));
        }
    }

    public static int fibonacci_recursion(int n) {
        if (n <= 1 ) {
            return n;
        }
        //recursion to calculate value
        return fibonacci_recursion(n - 1) + fibonacci_recursion(n - 2);
    }

    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0");
        }
        if (n <= 1) {
            return n;
        }

        int previous = 0;
        int current = 1;
        for (int index = 2; index <= n; index++) {
            int next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }
}
