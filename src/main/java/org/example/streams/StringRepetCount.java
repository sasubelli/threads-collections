package org.example.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StringRepetCount {
    static void main(String[] args) {
        String str1 = "adbcwersadxccvdccc$$$$$$$$$$$$$$####";
        int value = 0;
        char key = str1.charAt(0);
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);
            if (value < map.get(str1.charAt(i))) {
                key = str1.charAt(i);
                value = map.get(str1.charAt(i));
            }
        }
        System.out.println(key + " : " + value);

        //Stream version of writing
        Map<Character, Long> map2 = str1.chars()
                .mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(map2.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList()
                .reversed().stream().findFirst());

        Integer temp = 128;
        Integer tempb = 128;

        System.out.println(tempb == temp);
        System.out.println(tempb.equals(temp));

        int a = 1000;
        int b = 1000;
        if (a == b)
            System.out.println("true");

// stream api question
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum: " + sum);
    }
}
