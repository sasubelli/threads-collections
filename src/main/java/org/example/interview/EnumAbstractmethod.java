package org.example.interview;

enum Operation {
    ADD{
        public int execute(int a, int b) {
            return a + b;
        }
    },
    SUB{
        public int execute(int a, int b) {
            return a - b;
        }
    },
    MUL{
        public int execute(int a, int b) {
            return a * b;
        }
    },
    DIV{
        public int execute(int a, int b) {
            return a / b;
        }
    };
    public abstract int execute(int x, int y) ;
}

public class EnumAbstractmethod {
     static void main() {
        Operation op = Operation.ADD;
        int a = op.execute(1, 2);
        System.out.println(a);
        Operation op2 = Operation.SUB;
        int b = op2.execute(3, 2);
        System.out.println(b);
        Operation op3 = Operation.MUL;
        int c = op3.execute(1, 2);
        System.out.println(c);
        Operation op4 = Operation.DIV;
        int d = op4.execute(4, 2);
        System.out.println(d);

    }
}




