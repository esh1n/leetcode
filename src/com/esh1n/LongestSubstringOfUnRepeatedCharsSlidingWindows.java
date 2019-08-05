package com.esh1n;

import java.util.HashSet;


public class LongestSubstringOfUnRepeatedCharsSlidingWindows {

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
        int n = s.length();
        int ans = 0, i = 0, j = 0;
        HashSet set = new HashSet();
        while (i < n && j < n) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(s.charAt(j));
                j++;
                ans = Math.max(j - i, ans);
            }
        }
        return ans;
    }
}
