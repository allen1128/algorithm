package com.xl.algo;

import java.util.TreeSet;

public class NearByWithinDefinedLimit {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0 || k < 1|| nums == null || nums.length == 0) return false;

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            //find the lower bound or closing from above
            Long ceiling = set.ceiling((long) nums[i] - t);

            //find the upper bound or closing from below
            Long floor = set.floor((long) nums[i] + t);

            //truf if floor > nums[i] > ceiling which means nums[i] within range
            if ((ceiling != null && ceiling <= nums[i]) || (floor != null && floor >= nums[i])) {
                return true;
            }

            set.add((long) nums[i]);


            //remove when moving out of range
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        NearByWithinDefinedLimit mbwdl = new NearByWithinDefinedLimit();
        System.out.println(mbwdl.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
    }
}
