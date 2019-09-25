package com.xl.algo;

import java.util.Arrays;

public class MissingNumber {
    public void helper(int[] nums, int index) {
        if (index >= nums.length || index == -1 || nums[index] == -1) {
            return;
        }
        int i = nums[index];
        nums[index] = -1;
        helper(nums, i);
    }

    public int missingNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            helper(nums, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                return i;
            }
        }
        return nums.length;
    }

    public int missingNumber(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;
        for (int num : nums) {
            sum -=num;
        }
        return sum;
    }

    public static void main(String args[]) {
        MissingNumber mn = new MissingNumber();
        System.out.println(mn.missingNumber(new int[] {9,6,4,2,3,5,7,0,8}));
    }
}
