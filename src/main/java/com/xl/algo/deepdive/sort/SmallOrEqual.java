package com.xl.algo.deepdive.sort;

public class SmallOrEqual {
    public int solve(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (data[mid] > target) {
                right = mid;
            } else if (data[mid] < target) {
                left = mid;
            } else {
                return mid;
            }
        }

        if (data[right] <= target) {
            return right;
        } else {
            return left;
        }
    }


    public static void main(String[] args) {
        SmallOrEqual se = new SmallOrEqual();
        System.out.println(se.solve(new int[]{1, 2, 3, 4, 5, 7}, 7));
    }
}
