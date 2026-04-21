package org.example.solidprinciple;

import java.util.List;

abstract class Shape {
    abstract double getArea();
}

final class Rectangle extends Shape {
    private final int width;
    private final int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double getArea() {
        return width * height;
    }
}

final class Square extends Shape {
    private final int side;

    Square(int side) {
        this.side = side;
    }

    @Override
    double getArea() {
        return side * side;
    }
}

final class AreaCalculator {
    double getTotalArea(List<Shape> shapes) {
        return shapes.stream().mapToDouble(Shape::getArea).sum();
    }
}

public final class Liskovprinciple {
    private Liskovprinciple() {
    }

    public static void main(String[] args) {
        List<Shape> shapes = List.of(
                new Rectangle(10, 20),
                new Rectangle(5, 6),
                new Square(10),
                new Square(20)
        );

        AreaCalculator calculator = new AreaCalculator();
        System.out.println("Total area = " + calculator.getTotalArea(shapes));
    }
}
