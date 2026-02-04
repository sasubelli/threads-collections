package org.example.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramDetection {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("listen", "silent", "enlist", "rat", "tar", "apple","srtysysy");

        Map<String, List<String>> anagrams = words.stream()
                .collect(Collectors.groupingBy(word -> {
                    // 1. Convert word to char array
                    char[] chars = word.toLowerCase().toCharArray();
                    // 2. Sort the array
                    Arrays.sort(chars);
                    // 3. Return as a String (the "Key")
                    return new String(chars);
                }));
System.out.println(anagrams);
// Filter to keep only the groups that actually have anagrams (size > 1)
        List<List<String>> result = anagrams.values().stream()
                .filter(group -> group.size() > 1)
                .toList();

        System.out.println(result);
// Output: [[listen, silent, enlist], [rat, tar]]

    }
}
