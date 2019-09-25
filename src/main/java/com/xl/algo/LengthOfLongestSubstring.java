package com.xl.algo;

import java.util.Arrays;

public class LengthOfLongestSubstring {
    public static int solve(String s) {
        int[] saw = new int[128];
        int startAt = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            int index = (int) s.charAt(i);
            if (saw[index] > 0) {
                startAt = Math.max(startAt, s.lastIndexOf(s.charAt(i), i - 1) + 1);
            }
            saw[index] = 1;
            maxLength = Math.max(i - startAt + 1, maxLength);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(LengthOfLongestSubstring.solve("zabcdefgzzzzz"));
    }
}
