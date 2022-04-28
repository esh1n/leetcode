package com.esh1n.problems;


public class P151_Reverse_Words_In_String {
    public static void main(String[] args) {
        String input = "aa good   example";
        System.out.println(reverseWords(input));
    }

    public static String reverseWords(String input) {
        StringBuilder result = new StringBuilder();
        int firstIndex = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            if (i == 0) {
                result.append(input, 0, firstIndex + 1);
            }
            if (input.charAt(i) == ' ') {
                if (firstIndex != 0) {
                    result.append(input, i + 1, firstIndex + 1);
                    result.append(" ");
                    firstIndex = 0;
                }
            } else {
                if (firstIndex == 0) {
                    firstIndex = i;
                }
            }
        }
        return result.toString().trim();
    }
}
