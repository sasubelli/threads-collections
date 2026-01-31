package org.example.interview;

interface A {
    class B {
        void printMessage(int a) {
            System.out.println(a);
        }
    }
}

public class AnonymosInnerclass implements A {

    public AnonymosInnerclass() {
        B b = new B();
        b.printMessage(1);
    }

    static void main() {
        AnonymosInnerclass a = new AnonymosInnerclass();

    }
}
