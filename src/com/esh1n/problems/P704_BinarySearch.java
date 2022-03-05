package com.esh1n.problems;

public class P704_BinarySearch {
    public static void main(String[] args) {
        int[] input = {1, 3, 5, 7, 9};
        int res1 = binarySearch(input, 3);
        System.out.println("found element in position :" + (res1 == 1));
        int res2 = binarySearch(input, 15);
        System.out.println("2found element in position :" + (res2 == -1));
    }

    public static int binarySearch(int[] nums, int target) {
        int lowBorder = 0;
        int highBorder = nums.length - 1;
        while (lowBorder <= highBorder) {
            int mid = (lowBorder + highBorder) / 2;
            int guess = nums[mid];
            if (target == guess) {
                return mid;
            } else if (target > guess) {
                lowBorder = mid + 1;
            } else {
                highBorder = mid - 1;
            }
        }
        return -1;
    }
}
