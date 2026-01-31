package org.example.interview;

interface bird {
    void say();

    void say(int a);

    void say(int a, int b);

    void say(int a, int b, int c);

    void say(int a, int b, int c, int d);
}

abstract class abstarctbird implements bird {
    @Override
    public void say() {
        System.out.println("say 0");
    }

    @Override
    public void say(int a) {
        System.out.println("say 1");
    }

    @Override
    public void say(int a, int b) {
        System.out.println("say 2");
    }
}

public class Interfaceexample extends abstarctbird {
    static void main() {
        Interfaceexample obj = new Interfaceexample();
        obj.say();
        obj.say(1);
        obj.say(1, 2);
        obj.say(1, 2, 3);
        obj.say(1, 2, 3, 4);
    }

    public void say(int a, int b, int c, int d) {
        System.out.println("say 4");
    }

    public void say(int a, int b, int c) {
        System.out.println("say 3");
    }
}
