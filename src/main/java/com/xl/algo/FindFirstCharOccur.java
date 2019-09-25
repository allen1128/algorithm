package com.xl.algo;

public class FindFirstCharOccur {

    public static int firstUniqChar(String s) {
        int[] occur = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a';
            occur[num]++;
        }

        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a';
            if (occur[num] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FindFirstCharOccur.firstUniqChar("lleetcode"));
    }
}
