package com.esh1n.problems;

public class P27_RemoveElement {
    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};

        int res = removeElement(nums, 2);
        System.out.print("result: " + res);
        System.out.println();
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    //0, 1, 4, 0, 3, 2, 2,[2
    public static int removeElement(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            if (nums[left] == target) {
                int swap = nums[left];
                nums[left] = nums[right];
                nums[right] = swap;
                right--;
            }
            if (nums[left] != target) {
                left++;
            }
        }
        return left;
    }
}
