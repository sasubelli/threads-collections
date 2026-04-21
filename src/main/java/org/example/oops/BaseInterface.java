package org.example.oops;

public interface BaseInterface {
    void display();

    default void display2() {
        System.out.println("Default method from BaseInterface");
    }

    static void staticDisplay3() {
        System.out.println("Static method from BaseInterface");
    }
}
