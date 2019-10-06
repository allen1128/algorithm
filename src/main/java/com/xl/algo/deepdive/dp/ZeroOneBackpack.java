package com.xl.algo.deepdive.dp;

import com.xl.algo.deepdive.backtracking.ZeroOneBackPack;

public class ZeroOneBackpack {
    public int solve(int[] items, int w){
        boolean[][] states = new boolean[items.length][w+1];

        //first item
        states[0][0] = true; //not taking
        states[0][items[0]] = true; //taking

        for (int i = 1; i < items.length; i++) {
            for (int j = 0; j <= w; j++) { //not taking
                if (states[i-1][j]) {
                    states[i][j] = true;
                }
            }

            for (int j = 0; j <= w-items[i]; j++) {
                if (states[i-1][j]) {
                    states[i][j+items[i]] = true;
                }
            }
        }

        for (int i = w; i >= 0; i--) {
            if (states[items.length - 1][w]) {
                return w;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        ZeroOneBackpack zobp = new ZeroOneBackpack();
        System.out.println(zobp.solve(new int[] {1, 3, 5, 6}, 4));
    }
}
