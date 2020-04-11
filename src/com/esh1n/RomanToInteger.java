package com.esh1n;

public class RomanToInteger {

    public static void main(String[] args) {
        String[] digits = {"III", "IV", "IX", "LVIII", "MCMXCIV"};
        RomanToInteger romanToInteger = new RomanToInteger();
        for (String arg : digits) {
            int result = romanToInteger.romanToInt(arg);
            System.out.println("arg: " + arg + "result: " + result);
        }
    }

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else {
            if (s.length() == 1) {
                return romanTable(s.charAt(0));
            }
            int sum = 0;
            int index = 0;
            while (index < s.length()) {
                char prev = s.charAt(index);
                int nextIndex = index + 1;
                if (nextIndex < s.length() && isNeedToDecrease(prev, s.charAt(nextIndex))) {
                    sum += romanTable(s.charAt(nextIndex)) - romanTable(prev);
                    index += 2;
                } else {
                    sum += romanTable(prev);
                    index++;
                }
            }
            return sum;
        }
    }

    private boolean isNeedToDecrease(char before, char after) {
        switch (before) {
            case 'I':
                if (after == 'V' || after == 'X') {
                    return true;
                }
            case 'X':
                if (after == 'L' || after == 'C') {
                    return true;
                }
            case 'C':
                if (after == 'D' || after == 'M') {
                    return true;
                }
        }
        return false;
    }

    public int romanTable(char c) {
        int num = 0;
        switch (c) {
            case 'I':
                num = 1;
                break;
            case 'V':
                num = 5;
                break;
            case 'X':
                num = 10;
                break;
            case 'L':
                num = 50;
                break;
            case 'C':
                num = 100;
                break;
            case 'D':
                num = 500;
                break;
            case 'M':
                num = 1000;
                break;
            default:
                num = 0;
                break;
        }
        return num;
    }
}