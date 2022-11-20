package com.esh1n.problems;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class P151_Reverse_Words_In_String {
    public static void main(String[] args) {
        String input = "aa good   example";
        System.out.println(reverseWords(input));
    }

    //012345
    public static String reverseWords(String input) {
        Stack<String> words = new Stack<>();
        int firstIndex = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                firstIndex = i + 1;
            } else if (i == input.length() - 1 || input.charAt(i + 1) == ' ') {
                words.push(input.substring(firstIndex, i + 1));
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(words.pop());
        while (!words.isEmpty()) {
            result.append(" ");
            result.append(words.pop());

        }
        return result.toString();
    }

//    public static String reverseWords2(String input) {
//        StringBuilder result = new StringBuilder();
//        int lastIndex = input.length();
//        for (int i = input.length() - 1; i >= 0; i--) {
//            if (input.charAt(i) == ' ') {
//                lastIndex = i;
//            } else if (i == 0 || input.charAt(i - 1) == ' ') {
//                if (result.length() != 0) {
//                    result.append(" ");
//                }
//                result.append(input, i, lastIndex);
//            }
//        }
//        return result.toString();
//    }
}
