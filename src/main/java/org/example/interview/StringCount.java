package org.example.interview;

import java.util.HashMap;
import java.util.Map;

public final class StringCount {
    private StringCount() {
    }

    public static void main(String[] args) {
        String input = "adasasfsfdsgdgdhgdhd";
        System.out.println("Longest unique substring length = " + longestUniqueSubstringLength(input));
        System.out.println("Character frequency = " + frequencyMap(input));
    }

    public static int longestUniqueSubstringLength(String input) {
        int left = 0;
        int max = 0;
        Map<Character, Integer> lastSeen = new HashMap<>();

        for (int right = 0; right < input.length(); right++) {
            char current = input.charAt(right);
            if (lastSeen.containsKey(current)) {
                left = Math.max(left, lastSeen.get(current) + 1);
            }
            lastSeen.put(current, right);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static Map<Character, Integer> frequencyMap(String input) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char current : input.toCharArray()) {
            frequency.put(current, frequency.getOrDefault(current, 0) + 1);
        }
        return frequency;
    }
}
