package com.xl.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonAfterNDays {
    public Map<String, Integer> memo = new HashMap<>();

//    public int[] prisonAfterNDays(int[] cells, int N) {
//        if (N == 0) return cells;
//
//        int[] newCells = new int[cells.length];
//        for (int i = 1; i < cells.length - 1; i++) {
//            newCells[i] = (cells[i - 1] ^ cells[i+1]) == 0 ? 1 : 0;
//        }
//        String str = Arrays.toString(newCells);
//
//        Integer i = memo.get(str);
//        if (i == null) {
//            memo.put(str, N);
//        } else {
//            N = N % (i - N);
//        }
//
//        if (N == 0) return newCells;
//
//        return prisonAfterNDays(newCells, --N);
//    }


    public int[] prisonAfterNDays(int[] cells, int N) {
        if (N == 0) return cells;

        String str = Arrays.toString(cells);
        Integer last = memo.get(str);
        if (last == null) {
            memo.put(str, N);
        } else {
            N = N % (last - N);
        }

        if (N == 0) return cells;

        int[] newCells = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            newCells[i] = (cells[i - 1] ^ cells[i+1]) == 0 ? 1 : 0;
        }
        return prisonAfterNDays(newCells, --N);
    }

    public static void main(String[] args) {
        PrisonAfterNDays pan = new PrisonAfterNDays();
        System.out.println(Arrays.toString(pan.prisonAfterNDays(new int[] {1,0,0,1,0,0,1,0}, 1000000000)));
    }
}
