package org.example.streams;

import java.util.List;
import java.util.Optional;

public final class OptionalExamples {
    private OptionalExamples() {
    }

    public static void main(String[] args) {
        Optional<String> firstLongWord = List.of("java", "stream", "collection").stream()
                .filter(word -> word.length() > 5)
                .findFirst();

        System.out.println(firstLongWord.orElse("Not found"));
        System.out.println(firstLongWord.map(String::toUpperCase).orElse("DEFAULT"));
    }
}
