package org.example.streams;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class ListToMap {
    private ListToMap() {
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Map<Integer, Integer> squares = numbers.stream()
                .collect(Collectors.toMap(Function.identity(), value -> value * value));

        List<String> words = List.of("One", "Two", "Three", "Four");
        Map<Integer, String> byLength = words.stream()
                .collect(Collectors.toMap(String::length, Function.identity(), (left, right) -> left));

        Map<String, Long> frequency = List.of("java", "stream", "java", "map").stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Squares = " + squares);
        System.out.println("By length = " + byLength);
        System.out.println("Frequency = " + frequency);
        System.out.println("Non-null values = " + words.stream().filter(Objects::nonNull).toList());
    }
}
