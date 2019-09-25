package com.xl.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GardenNoAdj {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> G = new HashMap<>();

        for (int i = 0; i < N; i++) G.put(i, new HashSet<>());

        for (int[] p : paths) {
            G.get(p[0] - 1).add(p[1] - 1);
            G.get(p[1] - 1).add(p[0] - 1);
        }

        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            int[] colors = new int[4];
            //mark colors have been taken by its neighbour
            for (int j : G.get(i)) {
                colors[res[j]] = 1;
            }
            //pick the one has not been taken
            for (int c = 3; c >= 0; --c) {
                if (colors[c] == 0) {
                    res[i] = c;
                    break;
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            res[i]++;
        }
        return res;
    }

    public static void main(String[] args) {
        GardenNoAdj gna = new GardenNoAdj();
        System.out.println(Arrays.toString(gna.gardenNoAdj(4, new int[][]{{1, 2}, {3, 4}})));


    }
}
