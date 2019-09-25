package com.xl.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public int numFriendRequests(int[] ages) {
        if (ages.length <= 1) {
            return 0;
        }

        int res = 0;
        Arrays.sort(ages);
        for (int i = 0; i < ages.length; i++) {
            for (int j = i + 1; j < ages.length; j++) {
                if (ages[i] == ages[j]) {
                    System.out.println(String.format("%s sent 2 request to %s", ages[j], ages[i]));
                    res += 2;
                } else if (ages[i] > (ages[j] * 0.5 + 7)) {
                    System.out.println(String.format("%s sent 1 request to %s", ages[j], ages[i]));
                    res++;
                }
            }
        }

        return res;
    }

    public static class Combo {
        int profit;
        int diff;
        public Combo(int d, int p) {
            this.profit = p;
            this.diff = d;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int sum = 0;
        List<Combo> comboes = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            comboes.add(new Combo(difficulty[i], profit[i]));
        }

        comboes.sort((a, b) -> {
            if (a.profit < b.profit) {
                return 1;
            } else if (a.profit > b.profit) {
                return -1;
            } else if (a.diff > b.diff) {
                return 1;
            } else {
                return -1;
            }
        });
        for (int w : worker) {
            for (Combo c : comboes) {
                if (w >= c.diff) {
                    sum += c.profit;
                    break;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.maxProfitAssignment(new int[]{68,35,52,47,86}, new int[]{67,17,1,81,3}, new int[]{92,10,85,84,82}));
    }
}
