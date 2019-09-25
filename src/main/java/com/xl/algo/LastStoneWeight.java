package com.xl.algo;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            queue.add(stone);
        }
        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                return queue.poll();
            }

            int larger = queue.poll();
            int smaller = queue.poll();

            int left = larger - smaller;
            if (left > 0) {
                queue.add(left);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LastStoneWeight lsw = new LastStoneWeight();
        System.out.println(lsw.lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
