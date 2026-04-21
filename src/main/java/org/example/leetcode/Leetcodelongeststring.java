package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public final class Leetcodelongeststring {
    public static void main(String[] args) {
        Leetcodelongeststring solver = new Leetcodelongeststring();
        System.out.println(solver.lengthOfLongestSubstring("qwewrdxfdfnf"));
        System.out.println(solver.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String value) {
        int left = 0;
        int max = 0;
        Map<Character, Integer> lastSeen = new HashMap<>();

        for (int right = 0; right < value.length(); right++) {
            char current = value.charAt(right);
            if (lastSeen.containsKey(current)) {
                left = Math.max(left, lastSeen.get(current) + 1);
            }
            lastSeen.put(current, right);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
