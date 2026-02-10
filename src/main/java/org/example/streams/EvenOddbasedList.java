package org.example.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvenOddbasedList {
    static void main() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.stream().filter(number -> number % 2 == 0).forEach(System.out::println);
        numbers.stream().filter(number -> number % 2 != 0).forEach(System.out::println);
        Map<Boolean, List<Integer>> map = numbers.stream().mapToInt(Integer::intValue).boxed().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        map.entrySet().forEach(System.out::println);
        List<Integer> evenbasedList = map.getOrDefault(true, List.of());
        List<Integer> oddbasedList2 = map.getOrDefault(false, List.of());
        evenbasedList.addAll(oddbasedList2);
        System.out.println(evenbasedList);
        map.entrySet().forEach(System.out::println);
    }
}
