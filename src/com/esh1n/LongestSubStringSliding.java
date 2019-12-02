package com.esh1n;

import java.util.HashSet;

public class LongestSubStringSliding {

    public static void main(String[] args) {
        String firstRow = "abcabcbb";
        String secondRow = "bbbbb";
        String thirdRow = "pwwkew";
        String emptyRow = "abcdbcd";
        System.out.println("count 1:" + lengthOfLongestSubstring(emptyRow));
        System.out.println("count 1:" + lengthOfLongestSubstring(firstRow));
        System.out.println("count 2:" + lengthOfLongestSubstring(secondRow));
        System.out.println("count 3:" + lengthOfLongestSubstring(thirdRow));
    }

    private static int lengthOfLongestSubstring(String s) {
        int max = 0, left = 0, right = 0;
        HashSet<Character> set = new HashSet<>();
        while (left < s.length() && right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;

            } else {
                set.add(s.charAt(right++));
                max = Math.max(max, set.size());
            }
        }

        return max;
    }

}
