package org.example.oops;

public interface BaseInterface {
    void display();
    default void display2(){
        System.out.println("test-class-default-display2");
    }
     static void staticDisplay3(){
        System.out.println("test-class-static-Display3");
    }
}
