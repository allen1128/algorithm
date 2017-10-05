package com.xl.algo;

public class BestTimeToSellStock {
    public int maxProfile(int[] prices){
        if (prices.length <= 1){
            return 0;
        }

        int max = 0;
        int low = prices[0];

        for (int i = 1; i < prices.length; i++){
            low = Math.min(low, prices[i]);
            max = Math.max(max, prices[i] - low);
        }

        return max;
    }
}
