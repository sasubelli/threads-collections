package org.example.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetcodeSumoftwonumbers {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> alist = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {

                if(alist.containsKey(target-nums[i])){
                    return new int[]{alist.get(target-nums[i]),i};
                }else {
                    alist.put(nums[i],i);
                }
            }
            return null;
    }

    public static void main(String[] args) {
        LeetcodeSumoftwonumbers leetcode = new LeetcodeSumoftwonumbers();
        System.out.println("Array of two number "+ Arrays.toString(leetcode.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("Array of two number "+ Arrays.toString(leetcode.twoSum(new int[]{3,2,4}, 6)));

    }
}
