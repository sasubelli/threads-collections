package org.example.streams;

import java.util.*;

public class StreamIntermediateOparations {

    public static void main(String[] args) {
        // List of lists of names
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Reflection", "Collection", "Stream"),
                Arrays.asList("Structure", "State", "Flow"),
                Arrays.asList("Sorting", "Mapping", "Reduction", "Stream")
        );

        // Create a set to hold intermediate results
        Set<String> intermediateResults = new HashSet<>();

        // Stream pipeline demonstrating various intermediate operations
        List<String> result = listOfLists.stream()
                .flatMap(List::stream)
                .filter(s -> s.startsWith("S"))
                .map(String::toUpperCase)
                .distinct()
                .sorted(Comparator.nullsFirst(Comparator.comparing(String::length)) )
                .peek(intermediateResults::add)
                .toList();


        // Print the intermediate results
        System.out.println("Intermediate Results:");
        intermediateResults.forEach(System.out::println);

        // Print the final result
        System.out.println("Final Result:");
        result.forEach(System.out::println);

        List<String> interline = new ArrayList<>();
        List<String> result1 = listOfLists.stream()
                .flatMap(List::stream)
                .filter(s -> s.contains("S"))
                .map(String::toUpperCase)
                .distinct()
                .sorted().peek(interline::add)
                .toList();
        System.out.println("Intermediate Results:");
        interline.forEach(System.out::println);
        System.out.println("Final Result:");
        result1.forEach(System.out::println);
        System.out.println(" Results:  "+ result1);

        List<List<Integer>> listOfItegers = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(3,4,5,6),
                Arrays.asList(9,8,7,6)
        );

        System.out.println("Intermediate Integers:"+listOfItegers.stream().flatMap(List::stream).distinct().sorted(Comparator.reverseOrder()).toList());
    }
}
