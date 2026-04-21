package org.example.interview;

public final class AnonymosInnerclass {
    private AnonymosInnerclass() {
    }

    interface Greeting {
        void print(String name);
    }

    public static void main(String[] args) {
        Greeting anonymous = new Greeting() {
            @Override
            public void print(String name) {
                System.out.println("Hello from anonymous class, " + name);
            }
        };

        Greeting lambda = name -> System.out.println("Hello from lambda, " + name);

        anonymous.print("Java");
        lambda.print("Interview");
    }
}
