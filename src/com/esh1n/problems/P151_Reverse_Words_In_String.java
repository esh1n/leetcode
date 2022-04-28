package com.esh1n.problems;


public class P151_Reverse_Words_In_String {
    public static void main(String[] args) {
        String input = "aa good   example";
        System.out.println(reverseWords(input));
    }

    public static String reverseWords(String input) {
        StringBuilder result = new StringBuilder();
        int lastIndex = input.length();
        for (int i = input.length()-1; i >= 0; i--) {
            if(input.charAt(i) == ' '){
                lastIndex = i;
            }else if (i == 0|| input.charAt(i - 1) == ' ') {
                if(result.length()!=0){
                    result.append(" ");
                }
                result.append(input, i, lastIndex);
            }
        }
        return result.toString();
    }
}
