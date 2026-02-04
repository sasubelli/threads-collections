package org.example.streams;

import java.util.Comparator;
import java.util.List;

import static java.lang.System.*;

public class SecondHighestSalary {
    public static void main(String[] args) {
        Employee e1 = new Employee("John", "Smith", 5000);
        Employee e2 = new Employee("John", "POth", 5500);
        Employee e7 = new Employee("John", "math", 6000);

        List< Employee> employees = List.of(e1, e2, e7);
            employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(2)
                .skip(1)
                    .findFirst()
                    .ifPresentOrElse(out::println,() -> out.println("No employee found"));
               // .forEach(System.out::println);

        employees.stream()
                .map(Employee::getSalary)          // 1. Extract salary first
                .distinct()                        // 2. Handle duplicate salaries
                .sorted(Comparator.reverseOrder()) // 3. Sort descending
                .skip(1)                           // 4. Skip the highest
                .findFirst()                       // 5. Terminal operation
                .ifPresentOrElse(
                        out::println,
                        () -> out.println("Second highest salary not found")
                );
    }
}
