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

        public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0;i<n-1;i++)
            for(int j = i+1;j<=n;j++){
                if(allUnique(s,i,j)) ans = Math.max(ans, j-i);
            }
         return ans;
                   
    }
    
    public boolean allUnique(String s,int start, int end){
        Set<Character> set = new HashSet<>();
        for(int i = start; i< end;i++){
            Character ch = s.charAt(i);
            if(set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
}
