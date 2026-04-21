package org.example.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class AnagramDetection {
    private AnagramDetection() {
    }

    public static void main(String[] args) {
        List<String> words = List.of("listen", "silent", "enlist", "rat", "tar", "apple");

        Map<String, List<String>> grouped = words.stream()
                .collect(Collectors.groupingBy(AnagramDetection::sortCharacters));

        List<List<String>> onlyAnagrams = grouped.values().stream()
                .filter(group -> group.size() > 1)
                .toList();

        System.out.println("Grouped = " + grouped);
        System.out.println("Anagrams = " + onlyAnagrams);
    }

    private static String sortCharacters(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
