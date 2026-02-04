package org.example.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringManpulation {
    public static void main(String[] args) {
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("abcdad");
        listOfStrings.add("b");
        listOfStrings.add("abc");
        listOfStrings.stream().forEach(System.out::println);

        String input = "advancedstreams";

        Map<Character, Integer> map = input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.collectingAndThen(Collectors.counting(),Long::intValue)));
map.entrySet().forEach(System.out::println);

        Map<Character, Long> charFrequencies = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charFrequencies);
    }
}
