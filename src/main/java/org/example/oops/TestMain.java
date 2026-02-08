package org.example.oops;

public class TestMain {
    public static void main(String[] args) {

        //Record testing
        RecordTest recordTest= new RecordTest(1,"chan",20);
        System.out.println(recordTest + "   ID:"+ recordTest.id() + "   Name:"+recordTest.name() + "   Age:"+recordTest.age());

        //Interface Testing
         InterfaceImpl interfaceImpl = new InterfaceImpl();
         interfaceImpl.display();
         interfaceImpl.display2();
         BaseInterface.staticDisplay3();


    }
}
