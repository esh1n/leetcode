package com.esh1n.problems;

public class P28_strstr {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(" haystack =" + haystack + " needle " + needle +" :"+ strstr(haystack, needle));
        String haystack1 = "aabba";
        String needle1 = "bba";
        System.out.println(" haystack =" + haystack1 + " needle " + needle1  +" :"+ strstr(haystack1, needle1));
    }

    public static int strstr(String haystack, String needle) {
        if (haystack.isEmpty() && needle.isEmpty()) {
            return 0;
        } else if (needle.isEmpty()) {
            return 0;
        } else if (haystack.isEmpty() || needle.length() > haystack.length()) {
            return -1;
        } else {
            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                if (isFound(haystack, needle, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean isFound(String haystack, String needle, int position) {
        for (int j = 0; j < needle.length(); j++) {
            if (haystack.charAt(position + j) != needle.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
