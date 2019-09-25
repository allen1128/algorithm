package com.xl.algo;

public class Atoi {
    public int myAtoi(String str) {
        boolean negative = false;
        if (str.length() == 0) {
            return 0;
        }

        long result = 0;

        str = str.trim();
        int startIndex = 0;
        if (str.charAt(0) == '+') {
            startIndex++;
        }

        if (str.charAt(0) == '-') {
            startIndex++;
            negative = true;
        }

        for (int index = startIndex; index < str.length(); index++){
            char c = str.charAt(index);
            if (Character.isDigit(c)) {
                result = result * 10 + (c - '0');
                if (result >= (long) Integer.MAX_VALUE + 1 && negative) {
                    return Integer.MIN_VALUE;
                } else if (result >= Integer.MAX_VALUE && !negative) {
                    return Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }

        return (negative) ? -1 * (int) result : (int) result;
    }

    public static void main(String[] args) {
        System.out.println(new Atoi().myAtoi("+-2"));
    }
}
