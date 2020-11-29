package com.esh1n.problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int res1 = reverseInteger.reverse(1563847412);
        int res2 = reverseInteger.reverse(1200);
        int res3 = reverseInteger.reverse(100);
        int res4 = reverseInteger.reverse(-123);
    }

    public int reverse(int x) {

        int sign = (int) Math.signum(x);
        if (sign == 0) {
            return 0;
        }
        int value = Math.abs(x);
        if (value == Integer.MAX_VALUE || value == Integer.MIN_VALUE) {
            return 0;
        }
        int size = String.valueOf(value).length();
        List<Integer> digits = new ArrayList<>(size);
        while (value / 10 > 0) {
            int digit = value % 10;
            digits.add(digit);
            value /= 10;
        }
        int lastDigit = value % 10;
        digits.add(lastDigit);
        Iterator<Integer> iterator = digits.iterator();
        while ((iterator.hasNext() && iterator.next() == 0)) {
            iterator.remove();
        }
        int length = digits.size() - 1;
        int summary = digits.get(length);
        try {
            for (int i = 0; i < length; i++) {
                int powDegree = length - i;
                int power = power(10, powDegree);
                int newPart = Math.multiplyExact(power, digits.get(i));
                summary = Math.addExact(summary, newPart);
            }
        } catch (ArithmeticException e) {
            return 0;
        }

        return summary * sign;
    }

    int power(int digit, int degree) {
        if (degree == 0) {
            return 0;
        } else if (degree == 1) {
            return digit;
        } else {
            return digit * power(digit, degree - 1);
        }
    }

}
