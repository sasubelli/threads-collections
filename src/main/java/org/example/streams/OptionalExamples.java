package org.example.streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public final class OptionalExamples {
    private OptionalExamples() {
    }

    public static void main(String[] args) {
        Optional<String> firstLongWord = Stream.of("java", "stream", "collection")
                .filter(word -> word.length() > 5)
                .findFirst();

        System.out.println(firstLongWord.orElse("Not found"));
        System.out.println(firstLongWord.map(String::toUpperCase).orElse("DEFAULT"));
    }
}
