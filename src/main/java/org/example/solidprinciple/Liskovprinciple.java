package org.example.solidprinciple;


import java.util.ArrayList;
import java.util.List;
//instead of override getArea method in  square we should implement from abstract method.
abstract class Shape{
    abstract double getArea();
}

class Rectangle extends Shape{
    private final int width;
    private final int height;
    public Rectangle(int width,int height){
        this.width=width;
        this.height=height;
    }
    @Override
    double getArea(){
        return width*height;
    }
}

class Square extends Shape {
    int side;
    public Square(int length){
        this.side=length;
    }
    @Override
    double getArea(){
        return  side*side;
    }
}

class Areacalculator{
    //instead of using rectangle class use Shape class to access both square and rectangles.
    double getTotalArea(List<Shape> list){
        double totalArea=0.0;
        for(Shape shape:list){
            totalArea+=shape.getArea();
        }
        return totalArea;
    }
}

public class Liskovprinciple {
     static void main() {
        Areacalculator areacalculator = new Areacalculator();
        List<Shape> list=new ArrayList<>();
        list.add(new Rectangle(10,20));
        list.add(new Rectangle(10,20));
        list.add(new Rectangle(10,20));
        list.add(new Rectangle(10,20));
        list.add(new Rectangle(10,20));
        list.add(new Square(10));
        list.add(new Square(20));
        list.add(new Square(30));

        areacalculator.getTotalArea(list);
        System.out.println("total Area " +areacalculator.getTotalArea(list));

    }
}
