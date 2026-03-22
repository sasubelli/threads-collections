package org.example.interview;

import java.util.function.BiFunction;
import java.util.function.Function;

public class UpCasting extends Abc {
    @Override
    public  void display() {
        System.out.println("display");
    }
    @Override
    public void  execute(int a, int b) {
        System.out.println("execute  :: " + a + " : " + b);
    }
    public static void main(String[] args) {
        Abc upCasting = new UpCasting();
        upCasting.display();
        upCasting.execute(1,2);
        BiFunction<Integer, Integer, Integer> add = Integer::sum;
        BiFunction<Integer, Integer, Integer> sub =(a,b) ->a-b;
        System.out.println(add.apply(3,4));
        System.out.println(sub.apply(3,4));

        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, String> toString = x -> "Result tostring: " + x;
        Function<Integer, String> pipeline2 = square.andThen(s -> "Result: " + s);
        System.out.println(pipeline2.apply(3));
        Function<Integer, String> pipeline = square.andThen(toString);
        System.out.println(pipeline.apply(5));


    }
}
  abstract class Abc {

    public void display() {
        System.out.println("display1");

    }

    public abstract void execute(int a, int b) ;
}