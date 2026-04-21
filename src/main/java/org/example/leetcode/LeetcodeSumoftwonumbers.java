package org.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class LeetcodeSumoftwonumbers {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int complement = target - nums[index];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), index};
            }
            seen.put(nums[index], index);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        LeetcodeSumoftwonumbers solver = new LeetcodeSumoftwonumbers();
        System.out.println(Arrays.toString(solver.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(solver.twoSum(new int[]{3, 2, 4}, 6)));
    }
}
