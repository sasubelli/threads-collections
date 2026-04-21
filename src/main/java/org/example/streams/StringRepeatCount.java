package org.example.streams;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class StringRepeatCount {
    private StringRepeatCount() {
    }

    public static void main(String[] args) {
        String input = "adbcwersadxccvdccc$$$$$$$$$$$$$$####";
        Map<Character, Long> frequency = input.chars()
                .mapToObj(character -> (char) character)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map.Entry<Character, Long> maxEntry = frequency.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();

        System.out.println("Frequency = " + frequency);
        System.out.println("Most repeated = " + maxEntry);
        System.out.println("Sorted by frequency = " + frequency.entrySet().stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue(Comparator.reverseOrder()))
                .toList());
    }
}
