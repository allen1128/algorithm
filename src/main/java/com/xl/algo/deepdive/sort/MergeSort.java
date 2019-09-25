package com.xl.algo.deepdive.sort;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[]data, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) /2;
        mergeSort(data, helper, left, mid);
        mergeSort(data, helper, mid + 1, right);

        int leftS = left, rightS = mid + 1;
        int index = left;

        for (int i = left; i <= right; i++) {
            helper[i] = data[i];
        }

        while (leftS <= mid && rightS <= right) {
            if (helper[leftS] < helper[rightS]) {
                data[index++] = helper[leftS++];
            } else {
                data[index++] = helper[rightS++];
            }
        }

        while (leftS <= mid) {
            data[index++] = helper[leftS++];
        }

        while (rightS <= right) {
            data[index++] = helper[rightS++];
        }
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] data = new int[] {2, 6, 1, 3, 6, 8, 10, -2};
        ms.mergeSort(data, new int[data.length], 0, 7);
        System.out.println(Arrays.toString(data));
    }
}
