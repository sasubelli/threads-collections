package org.example.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class StringManipulation {
    private StringManipulation() {
    }

    public static void main(String[] args) {
        List<List<String>> nestedWords = List.of(
                List.of("abcdad", "qwewr", "abcdad"),
                List.of("b", "cd"),
                List.of("abc", "sde", "b", "abc")
        );

        String input = "advancedstreams";

        Map<Character, Long> characterFrequency = input.chars()
                .mapToObj(character -> (char) character)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> wordFrequency = nestedWords.stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Character frequency = " + characterFrequency);
        System.out.println("Repeated words = " + wordFrequency.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .toList());
    }
}
