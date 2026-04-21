package org.example.streams;

import java.util.Comparator;
import java.util.List;

public final class Employee {
    private final String firstName;
    private final String lastName;
    private final double salary;

    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public static List<Employee> sampleEmployees() {
        return List.of(
                new Employee("John", "Smith", 5000),
                new Employee("Anu", "Poth", 4000),
                new Employee("Rahul", "Garth", 3000),
                new Employee("Priya", "Lath", 6000),
                new Employee("John", "Poth", 5500)
        );
    }

    public static void main(String[] args) {
        System.out.println(sampleEmployees().stream()
                .sorted(Comparator.comparing(Employee::getLastName)
                        .thenComparing(Employee::getSalary))
                .toList());
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + salary + ")";
    }
}
