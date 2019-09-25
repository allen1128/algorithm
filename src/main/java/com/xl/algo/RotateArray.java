package com.xl.algo;

import java.util.ArrayList;
import java.util.List;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - k; i < nums.length; i++) {
            list.add(nums[i]); //buffer the nums
        }

        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i]; //move to the front
        }
        for (int i = 0; i < k; i++) {
            nums[i] = list.get(i); //replace
        }
        String str = new String();
        Integer aa = new Integer(1);

    }



    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        ra.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

}
