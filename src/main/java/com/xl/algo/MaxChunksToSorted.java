package com.xl.algo;

public class MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int max[] = new int[arr.length];
        max[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            max[i] = Math.max(max[i-1], arr[i]);
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max[i] == i) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        MaxChunksToSorted mcts = new MaxChunksToSorted();
        System.out.println(mcts.maxChunksToSorted(new int[] {1,2,0,3}));
    }
}
