package com.esh1n.problems;

public class P125_Valid_Palindrom {

    public static void main(String[] args) {
        String palind1 = "A man, a plan, a canal: Panama";
        String palind2 = "race a car";
        System.out.println("p1: " + isPalindrome(palind1));
        System.out.println("p2: " + isPalindrome(palind2));
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }

}

