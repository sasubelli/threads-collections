package org.example.streams;

import java.util.Comparator;
import java.util.List;

public final class StreamIntermediateOparations {
    private StreamIntermediateOparations() {
    }

    public static void main(String[] args) {
        List<List<String>> listOfLists = List.of(
                List.of("Reflection", "Collection", "Stream"),
                List.of("Structure", "State", "Flow"),
                List.of("Sorting", "Mapping", "Reduction", "Stream")
        );

        List<String> result = listOfLists.stream()
                .flatMap(List::stream)
                .filter(word -> word.startsWith("S"))
                .map(String::toUpperCase)
                .distinct()
                .sorted(Comparator.comparingInt(String::length).thenComparing(String::compareTo))
                .toList();

        System.out.println("Intermediate operations result = " + result);
    }
}
