package org.example.streams;

import java.util.Map;

public class StreamMethods {
    public static void main(String[] args) {
        Map<String, String> dict = Map.of("Java", "Programming Language");
        dict.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
