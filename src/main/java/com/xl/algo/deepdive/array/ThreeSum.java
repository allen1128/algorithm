package com.xl.algo.deepdive.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            result.addAll(twoSum(nums, nums[i], i));
        }
        return result;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        int low = start + 1;
        int high = nums.length-1;
        //mistake; used while loop instead of low and high, we need to shrink from both end to handle cases such as [0, 0, 0, 0] and [0, 0, 0]
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (-target == sum){
                List<Integer> temp = Arrays.asList(new Integer[] {target, nums[low] , nums[high]});
                result.add(temp);
                while (low < high && nums[low] == nums[low+1]) {low++;}
                while (low < high && nums[high] == nums[high-1]) {high--;}
                low++;
                high--;

            } else if (-target > sum) { //mistake
                low++;
            } else {
                high--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        System.out.println(ts.threeSum(new int[] {1, -1, -1, 0}));
    }
}
