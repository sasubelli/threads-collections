package org.example.interview;

import java.util.List;

public final class ImmutableClass {
    private final int id;
    private final String name;
    private final List<String> subjects;

    public ImmutableClass(int id, String name, List<String> subjects) {
        this.id = id;
        this.name = name;
        this.subjects = List.copyOf(subjects);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * Defensive copy in getter: prevents callers from modifying
     * the internal list after retrieving it.
     */
    public List<String> getSubjects() {
        //violation code commented
        //return new ArrayList<>(subjects);
        return List.copyOf(subjects);
    }

    public static void main(String[] args) {
        ImmutableClass student = new ImmutableClass(1, "Chandra", List.of("Maths", "Physics"));
        System.out.println(student.getName() + " -> " + student.getSubjects());
    }
}
