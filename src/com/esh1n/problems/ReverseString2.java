package com.esh1n.problems;

public class ReverseString2 {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String str) {
        int start = 0;
        StringBuilder words = new StringBuilder(str);
        for (int i = 0; i < words.length(); i++) {
            if (i == words.length() - 1 || words.charAt(i + 1) == ' ' ) {
                reverseWord(words, start, i);
            }else if(words.charAt(i) == ' '){
                start = i + 1;
            }
        }
        reverseWord(words, 0, str.length() - 1);
        return words.toString();
    }

    public static void reverseWord(StringBuilder wordBuilder, int start, int end) {
        while (start < end) {
            char tmp = wordBuilder.charAt(start);
            wordBuilder.setCharAt(start, wordBuilder.charAt(end));
            wordBuilder.setCharAt(end, tmp);
            start++;
            end--;
        }
    }
}
