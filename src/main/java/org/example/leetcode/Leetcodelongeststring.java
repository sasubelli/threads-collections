package org.example.leetcode;

public class Leetcodelongeststring {
     static void main(String[] args) {
    Leetcodelongeststring leetcode = new Leetcodelongeststring();
    System.out.printf(String.valueOf( leetcode.lengthOfLongestSubstring("qwewrdxfdfnf")));
    }
    //Given a string s, find the length of the longest substring without duplicate characters.
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if(s.length()>1) {
            for (int i = 0; i < s.length(); i++) {
                int left = 0;
                String sb;

                for (int j = i + 1; j < s.length(); j++) {
                    sb = s.substring(i, j);
                    left = left + 1;
                    max = Math.max(max, left);
                    if (sb.contains(s.substring(j, j + 1))) {
                        break;
                    }
if(j == s.length()-1){
    max = Math.max(max, left+1);
}
                }
            }
        }
        else {
            max = s.length();
        }
        return max;
    }
}
