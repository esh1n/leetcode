package com.esh1n.problems;

import java.util.HashMap;
import java.util.Map;

public class P01_2Sum {
    public static void main(String[] args) {
        int target = 6;
        int[] array = {1, 2, 8, 4, 3};
        int[] result = twoSum(array, target);
        System.out.println("index 1: " + result[0] + "index 2: " + result[1]);

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int search = target - nums[i];
            if (indexMap.containsKey(search)) {
                int searchIndex = indexMap.get(search);
                return new int[]{searchIndex, i};
            } else {
                indexMap.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
