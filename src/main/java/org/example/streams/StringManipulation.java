package org.example.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringManipulation {
    static void main() {
        List<List<String>> listOfStrings = new ArrayList<>();
        listOfStrings.add(Arrays.asList("abcdad", "qwewr", "abcdad"));
        listOfStrings.add(Arrays.asList("b", "cd"));
        listOfStrings.add(Arrays.asList("abc", "sde", "b", "abc"));
        listOfStrings.forEach(System.out::println);

        String input = "advancedstreams";

        Map<Character, Integer> map = input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
        map.entrySet().forEach(System.out::println);

        Map<Character, Long> charFrequencies = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charFrequencies);

        Map<String, Long> list = listOfStrings.stream().flatMap(List::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(list.entrySet().stream().filter(e -> e.getValue() > 1)
                .collect(Collectors.toList()));
    }
}
