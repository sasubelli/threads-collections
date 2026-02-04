package org.example.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    private String firstName;
    private String lastName;
    private double salary;
    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee toString:"+this.firstName+" "+this.lastName+" "+this.salary;
    }
    public static void main(String[] args) {
        Employee e1 = new Employee("John", "Smith", 5000);
        Employee e2 = new Employee("John", "POth", 4000);
        Employee e7 = new Employee("John", "POth", 5000);
        Employee e3 = new Employee("John", "Garth", 3000);
        Employee e4 = new Employee("John", "Lath", 6000);
        List<Employee> listOfEmployees = Arrays.asList(e1,e3,e4,e2,e7);

        //sorting based on lastname and salary
        System.out.println(listOfEmployees.stream()
                .sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getSalary).reversed())
                .collect(Collectors.toList()));
    }
}
