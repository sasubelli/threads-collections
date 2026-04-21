package org.example.interview;

enum Operation {
    ADD {
        @Override
        public int execute(int a, int b) {
            return a + b;
        }
    },
    SUB {
        @Override
        public int execute(int a, int b) {
            return a - b;
        }
    },
    MUL {
        @Override
        public int execute(int a, int b) {
            return a * b;
        }
    },
    DIV {
        @Override
        public int execute(int a, int b) {
            if (b == 0) {
                throw new IllegalArgumentException("Cannot divide by zero");
            }
            return a / b;
        }
    };

    public abstract int execute(int x, int y);
}

public final class EnumAbstractedness {
    private EnumAbstractedness() {
    }

    public static void main(String[] args) {
        for (Operation operation : Operation.values()) {
            System.out.println(operation + " => " + operation.execute(8, 2));
        }
    }
}
