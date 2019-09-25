package com.xl.algo.sort;

import java.util.Arrays;

public class MergeSort2 {

    public void mergeSort(int[] data, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(data, helper, left, mid);
        mergeSort(data, helper, mid + 1, right);

        //buffer the data so the partition can be done in place
        for (int i = left; i <= right; i++) {
            helper[i] = data[i];
        }

        int start = left;
        int sLeft = left;
        int sRight = mid + 1;
        while (sLeft <= mid && sRight <= right) {
            if (helper[sLeft] < helper[sRight]) {
                data[start++] = helper[sLeft++];
            } else {
                data[start++] = helper[sRight++];
            }
        }

        while (sLeft <= mid) {
            data[start++] = helper[sLeft++];
        }
    }

    public static void main(String[] args) {
        MergeSort2 ms2 = new MergeSort2();
        int[] data = new int[]{-3, 2, 1, 2, 5, -6};
        ms2.mergeSort(data, new int[6], 0, 5);
        System.out.println(Arrays.toString(data));
    }


}
