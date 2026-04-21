package org.example.oops;

public record RecordTest(Integer id, String name, Integer age) {
    public RecordTest {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("id must be positive");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name must not be blank");
        }
        if (age == null || age < 0) {
            throw new IllegalArgumentException("age must not be negative");
        }
    }

    public String summary() {
        return "%s (%d years old)".formatted(name, age);
    }
}
