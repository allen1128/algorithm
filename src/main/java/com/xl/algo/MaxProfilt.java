package com.xl.algo;

public class MaxProfilt {
    public int maxProfit(int[] prices) {
//         if (prices.length <= 1){
//             return 0;
//         }

//         int max = 0;
//         int low = prices[0];

//         for (int i = 1; i < prices.length; i++){
//             low = Math.min(low, prices[i]);
//             max = Math.max(max, prices[i] - low);
//         }

//         return max;
        int[] prof = new int[prices.length];
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            prof[i] = prices[i] - min;
        }


        int max = prices[prices.length - 1];
        int gmax = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            prof[i] += max - prices[i];
            gmax = Math.max(gmax, prof[i]);
        }


        return gmax;
    }

    public static void main(String[] args) {
        MaxProfilt mp = new MaxProfilt();
        System.out.println(mp.maxProfit(new int[] { 1, 2, 7, 5}));
    }
}
