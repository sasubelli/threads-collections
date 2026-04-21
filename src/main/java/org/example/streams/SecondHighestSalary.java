package org.example.streams;

import java.util.Comparator;

public final class SecondHighestSalary {
    private SecondHighestSalary() {
    }

    public static void main(String[] args) {
        Employee.sampleEmployees().stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .ifPresentOrElse(
                        salary -> System.out.println("Second highest salary = " + salary),
                        () -> System.out.println("Second highest salary not found")
                );
    }
}
