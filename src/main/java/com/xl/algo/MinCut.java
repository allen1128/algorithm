package com.xl.algo;

public class MinCut {
    public int minCut(String s) {
        boolean[][] palin = new boolean[s.length()][s.length()];
        int[] mincut = new int[s.length() + 1];

        for (int i = s.length(); i >= 0; i--) {
            mincut[i] = s.length() - i - 1;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (i + 1 >= j || palin[i + 1][j - 1])) {
                    palin[i][j] = true;
                    mincut[i] = Math.min(mincut[j + 1] + 1, mincut[i]);
                }
            }
        }

        return mincut[0];
    }

    public static void main(String[] args) {
        MinCut mc = new MinCut();
        System.out.println(mc.minCut("abacaaac"));
    }
}
