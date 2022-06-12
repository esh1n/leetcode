package com.esh1n.problems;

public class P28_strstr {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(" haystack =" + haystack + " needle " + needle +" :"+ strStr(haystack, needle));
        String haystack1 = "mississippi";
        String needle1 = "issi";
        System.out.println(" haystack =" + haystack1 + " needle " + needle1  +" :"+ strStr(haystack1, needle1));
    }

    public  static int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

}
