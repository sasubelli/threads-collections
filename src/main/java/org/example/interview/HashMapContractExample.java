package org.example.interview;

import java.util.HashMap;
import java.util.Map;

public final class HashMapContractExample {
    private HashMapContractExample() {
    }

    public static void main(String[] args) {
        Map<EmployeeKey, String> employees = new HashMap<>();
        employees.put(new EmployeeKey(101, "Amit"), "Backend Engineer");

        System.out.println("Lookup with equal key = " + employees.get(new EmployeeKey(101, "Amit")));
        System.out.println("Map size = " + employees.size());
    }
}

record EmployeeKey(int id, String name) {
}
