package org.example.streams;

import java.util.List;

public class StringPalindrome {
    public static void main(String[] args) {
        List<String> input = List.of(new String[]{"abccba","xyyx", " ", "ewrwer","xyxsed"});

        input.stream().filter(c -> new StringBuilder(c).reverse().toString().equalsIgnoreCase(c)).forEach(System.out::println);
    }
}
