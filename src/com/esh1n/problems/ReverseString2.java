package com.esh1n.problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReverseString2 {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        List<String> strings = new ArrayList<>();
        strings.add("Keanu");
        strings.add("Triniti");

        List<String> stringsLinked = new LinkedList<>();
        stringsLinked.add("Smith");
        stringsLinked.add("Sprut");

        Iterable<String> iterable = stringsLinked;
        Iterator<String> iterator = iterable.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
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
