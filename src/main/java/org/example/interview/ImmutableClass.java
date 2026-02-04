package org.example.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class ImmutableClass {
    private final int id;
    private final String name;
    private final List<String> subjects;

    public ImmutableClass(int id, String name, List<String> subjects) {
        this.id = id;
        this.name = name;
        // Defensive copy in constructor: prevents external list changes
        // from affecting this object's internal state.
        this.subjects = new ArrayList<>(subjects);
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
}

class Main {
    static void main() {
        ImmutableClass immutableClass = new ImmutableClass(1, "chandra", List.of(new String[]{"Maths", "Physics"}));
        List<String> strlist = immutableClass.getSubjects();
     //   strlist.add("Chemistry");
        System.out.println(strlist);

        // Try with resources example.
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                if (s.contains("break"))
                    break;
                System.out.println(s);

            }
        }
    }
}