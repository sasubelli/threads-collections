package org.example.interview;

import java.util.List;

public record TestRecord(Integer id, String name, List<String> subjects) {
    public TestRecord {
        subjects = List.copyOf(subjects);
    }

    public static void main(String[] args) {
        TestRecord record = new TestRecord(1, "Chandra", List.of("Maths", "Physics"));
        System.out.println(record);
        System.out.println("Subjects are immutable: " + record.subjects());
    }
}
