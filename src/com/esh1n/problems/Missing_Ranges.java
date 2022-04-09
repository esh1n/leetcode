package com.esh1n.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public class Missing_Ranges {
    public static void main(String[] args) {
        Integer[] ex1 = {0, 1, 3, 50, 75};

        printList(findMissingRanges(ex1, 0, 99));
    }

    public static void printList(List<String> outList) {
        for (String s : outList) {
            System.out.print(" " + s + " ");
        }
    }

    public static List<String> findMissingRanges(Integer[] valsArray, int start, int end) {
        List<String> ranges = new ArrayList<>();
        List<Integer> vals = new ArrayList<>(Arrays.asList(valsArray));
        vals.add(0, start - 1);
        vals.add(end + 1);
        for (int i = 0; i < vals.size() - 1; i++) {
            int current = vals.get(i);
            int next = vals.get(i + 1);
            if (next - current > 1) {
                ranges.add(getRangeDescription(current, next));
            }
        }
        return ranges;
    }

    public static String getRangeDescription(int start, int end) {
        BiFunction<Integer, Integer, String> edgeToStr =
                (edge, increment) -> String.valueOf(edge + increment);
        String startStr = edgeToStr.apply(start, 1);
        return end - start > 2 ? startStr + "->" + edgeToStr.apply(end, -1) : startStr;
    }
}


