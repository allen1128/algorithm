package com.xl.algo.deepdive.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZeroOneBackPack {
    private int maxW = Integer.MIN_VALUE;
    private boolean[][] memo;
    private List<Integer> added = new ArrayList<>();

    public int maxWeight(int[] items, int w) {
        memo = new boolean[items.length][w];
        helper(0, 0, items, items.length, w, new ArrayList<>());
        return maxW;
    }

    private void helper(int i, int cw, int[] items, int num, int w, List<Integer> added) {
        if (i == num || cw == w) {
            if (cw > maxW) {
                maxW = cw;
                this.added = new ArrayList<>(added);
            }
            return;
        }
        if (memo[i][cw]) return;
        memo[i][cw] = true;
        helper(i + 1, cw, items, num, w, added);
        if (cw + items[i] <= w) {
            Integer integer = Integer.valueOf(i);
            added.add(integer);
            helper(i + 1, cw + items[i], items, num, w, added);
            added.remove(integer);
        }
    }

    public static void main(String[] args) {
        ZeroOneBackPack zobp = new ZeroOneBackPack();
        System.out.println(zobp.maxWeight(new int[] {1, 3, 5, 6}, 4));
    }
}
