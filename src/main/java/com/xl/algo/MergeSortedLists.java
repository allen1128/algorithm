package com.xl.algo;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedLists {
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        //the key is to iterate backward.
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[6];
        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 3;
        int[] nums2 = {2, 2, 4};
        System.out.println(merge(nums1, 3, nums2, nums2.length));
    }
}
