package com.xl.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> reses = new ArrayList<>();
        Arrays.sort(nums);
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == prev) {
                continue;
            }
            Map<Integer, Integer> map = new HashMap<>();
            int prev1 = 0;
            boolean found = false;
            for (int j = i + 1; j < nums.length; j++) {
                Integer index = map.get(-nums[i]- nums[j]);
                if (found && index != null && nums[index] == prev1){
                    continue;
                }
                List<Integer> res = new ArrayList<>();
                if (index != null) {
                    res.add(nums[i]);
                    res.add(nums[index]);
                    res.add(nums[j]);
                    reses.add(res);
                    prev1 = nums[index];
                    found = true;
                }
                map.put(nums[j], j);
            }
            prev = nums[i];
        }
        return reses;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> reses = new ArrayList<>();
        Arrays.sort(nums);
        int prev = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == prev) {
                continue;
            }
            int lo = i + 1; int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                if (sum == -nums[i]) {
                    reses.add(Arrays.asList(new Integer[]{nums[i], nums[lo], nums[hi]}));
                    while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                    lo++;hi--;
                } else if (sum > -nums[i]) {
                    hi--;
                } else {
                    lo++;
                }
            }
            prev = nums[i];
        }
        return reses;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[] {-1,0,1,2,-1,-1,-4,0,2}));
    }
}
