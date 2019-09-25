package com.xl.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LastStoneWeightII {

    public int lastStoneWeightII(int[] stones) {
        List<Integer> stoneSet = Arrays.stream(stones).boxed().collect(Collectors.toList());

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stoneSet.size(); i++) {
            Integer stone = stoneSet.remove(i);
            min = Math.min(min, helper(stoneSet, stoneSet.get(i)));
            stoneSet.add(i, stone);
        }
        return min;
    }

    public int helper(List<Integer> stones, Integer prev) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stones.size(); i++) {
            Integer stone = stones.remove(i);
            int curr = stones.get(i);
            int left = Math.abs(curr - prev);
            if (left > 0) {
                stones.add(left);
            }
            min = Math.min(min, helper(stones, stones.get(i)));
            stones.remove(stones.size() - 1);
            stones.add(i, stone);
        }
        return min;
    }

    public static void main(String[] args) {
        LastStoneWeightII lsw = new LastStoneWeightII();
        System.out.println(lsw.lastStoneWeightII(new int[]{2,7,4,1,8,1}));
    }
}
