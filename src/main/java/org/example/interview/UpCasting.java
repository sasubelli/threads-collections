package org.example.interview;

import java.util.function.BiFunction;
import java.util.function.Function;

public class UpCasting extends Abc {
    @Override
    public void display() {
        System.out.println("Child display()");
    }

    @Override
    public void execute(int a, int b) {
        System.out.println("Child execute(): " + a + " + " + b + " = " + (a + b));
    }

    public static void main(String[] args) {
        Abc reference = new UpCasting();
        reference.display();
        reference.execute(4, 5);

        BiFunction<Integer, Integer, Integer> add = Integer::sum;
        BiFunction<Integer, Integer, Integer> subtract = (a, b) -> a - b;
        Function<Integer, Integer> square = value -> value * value;
        Function<Integer, String> describe = result -> "Result: " + result;

        System.out.println("Add = " + add.apply(3, 4));
        System.out.println("Subtract = " + subtract.apply(9, 2));
        System.out.println(square.andThen(describe).apply(5));
    }
}

abstract class Abc {
    public void display() {
        System.out.println("Parent display()");
    }

    public abstract void execute(int a, int b);
}
