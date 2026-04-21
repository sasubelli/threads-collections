package org.example.streams;

import java.util.List;
import java.util.Map;

public final class StreamMethods {
    private StreamMethods() {
    }

    public static void main(String[] args) {
        Map<String, String> dictionary = Map.of(
                "Java", "Programming Language",
                "Stream", "Sequence of elements supporting aggregate operations"
        );

        dictionary.forEach((key, value) -> System.out.println(key + ": " + value));

        List<String> output = dictionary.keySet().stream()
                .map(String::toUpperCase)
                .sorted()
                .toList();

        System.out.println("Uppercase keys = " + output);
    }
}
