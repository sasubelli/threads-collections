package org.example.oops;

public final class TestMain {
    private TestMain() {
    }

    public static void main(String[] args) {
        RecordTest record = new RecordTest(1, "Chandra", 20);
        System.out.println("Record: " + record);
        System.out.println("Summary: " + record.summary());

        InterfaceImpl implementation = new InterfaceImpl();
        implementation.display();
        implementation.display2();
        BaseInterface.staticDisplay3();

        new Testclass().display();
    }
}
