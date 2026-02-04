package org.example.interview;

import java.util.List;

public record TestRecord(Integer id, String name, List<String> subjects) {
     static void main(String[] args) {
        TestRecord ts = new TestRecord(1, "Chandra", List.of(new String[]{"Maths", "physics"}));
System.out.println(ts);
    }
}
