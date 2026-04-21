package org.example.interview;

interface Bird {
    void say();

    void say(int a);

    void say(int a, int b);

    void say(int a, int b, int c);

    void say(int a, int b, int c, int d);
}

abstract class AbstractBird implements Bird {
    @Override
    public void say() {
        System.out.println("say()");
    }

    @Override
    public void say(int a) {
        System.out.println("say(int): " + a);
    }

    @Override
    public void say(int a, int b) {
        System.out.println("say(int, int): " + a + ", " + b);
    }
}

public class Interfaceexample extends AbstractBird {
    public static void main(String[] args) {
        Interfaceexample example = new Interfaceexample();
        example.say();
        example.say(1);
        example.say(1, 2);
        example.say(1, 2, 3);
        example.say(1, 2, 3, 4);
    }

    @Override
    public void say(int a, int b, int c) {
        System.out.println("say(int, int, int): " + a + ", " + b + ", " + c);
    }

    @Override
    public void say(int a, int b, int c, int d) {
        System.out.println("say(int, int, int, int): " + a + ", " + b + ", " + c + ", " + d);
    }
}
