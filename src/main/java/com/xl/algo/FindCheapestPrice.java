package com.xl.algo;

public class FindCheapestPrice {
    public int min = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        helper(n, flights, src, dst, K, 0);
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }

    public void helper(int n, int[][] flights, int src, int dst, int K, int cost) {
        if (src == dst) {
            min = Math.min(cost, min);
            return;
        }
        if (K < 0) {
            return;
        }

        for (int i = 0 ; i < flights.length; i++) {
            if (flights[i][0] == src && flights[i][2] > 0) {
                helper(n, flights, flights[i][1], dst, K - 1, cost + flights[i][2]);
            }
        }
    }
    public static void main(String[] args) {
        FindCheapestPrice fcp = new FindCheapestPrice();
        int[][] flights = new int[][]{{0,1,100},{1,2,100},{0,2,500}};

        System.out.println(fcp.findCheapestPrice(3, flights, 0, 1, 1));
    }
}
