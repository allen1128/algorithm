package com.xl.algo;

public class InsertPos {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        while ( start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] < target) {
            return start + 1;
        } else {
            return start;
        }
    }

    public static void main(String[] args) {
        InsertPos insertPos = new InsertPos();
        System.out.println(insertPos.searchInsert(new int[]{1,2,3,4,5}, 6));
    }
}
