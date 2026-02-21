package org.example.dsa;

public class FibonacciSeris {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(Fibonacci(i )+ " ");
        }
    }
    public static int Fibonacci(int n) {
        if (n <= 1 ) {
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
