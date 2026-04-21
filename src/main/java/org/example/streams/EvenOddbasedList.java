package org.example.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class EvenOddbasedList {
    private EvenOddbasedList() {
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> partitioned =
                numbers.stream().collect(Collectors.partitioningBy(number -> number % 2 == 0));

        System.out.println("Even numbers = " + partitioned.get(true));
        System.out.println("Odd numbers = " + partitioned.get(false));
    }
}
