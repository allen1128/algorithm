package com.xl.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> reses = new ArrayList<>();
        Arrays.sort(nums);

        int[] test = reses.get(0).stream().mapToInt(Integer::valueOf).toArray();

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = target - (nums[i] + nums[j]);
                int lo = j + 1;
                int hi = nums.length - 1;
                while (lo < hi) {
                    int sum = nums[lo] + nums[hi];
                    if (sum == left) {
                        reses.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[lo], nums[hi]}));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (sum > left) {
                        hi--;
                    } else {
                        lo++;
                    }
                }
                while (j < nums.length - 1 && nums[j] == nums[j + 1]) j++;
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) i++;
        }
        return reses;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(new int[]{-3, -1, 0, 2, 4,5}, 2));
    }
}
