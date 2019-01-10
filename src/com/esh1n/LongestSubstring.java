package com.esh1n;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

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

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
