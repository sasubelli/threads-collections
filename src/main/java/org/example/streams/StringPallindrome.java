package org.example.streams;

import java.util.List;

public class StringPallindrome {
    public static void main(String[] args) {
        List<String> input = List.of(new String[]{"abccba", "", "ewrwer","xyxsed","xyyx"});

        input.stream()
                .filter(c -> c.equalsIgnoreCase(new StringBuilder(c).reverse().toString()))
                .forEach(System.out::println);
    }
}
