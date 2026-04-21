package org.example.streams;

import java.util.List;

public final class StringPalindrome {
    private StringPalindrome() {
    }

    public static void main(String[] args) {
        List<String> words = List.of("abccba", "xyyx", "java", "madam", "stream");
        words.stream()
                .filter(StringPalindrome::isPalindrome)
                .forEach(System.out::println);
    }

    public static boolean isPalindrome(String value) {
        return new StringBuilder(value).reverse().toString().equalsIgnoreCase(value);
    }
}
