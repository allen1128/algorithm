package com.xl.algo.sort;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] data, int[] helper, int left, int right) {
        System.out.println("left=" + left + ". right=" + right);
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2; //template to get mid

        mergeSort(data, helper, left, mid);
        mergeSort(data, helper, mid + 1, right);


        //the left to mid interval is sorted and mid+1 to right is sorted
        for (int i = left; i <= right; i++) {
            helper[i] = data[i];
        }

        int leftS = left, rightS = mid + 1;
        int index = left;
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
    }

    public static void main(String[] args) {
        int[] data = new int[]{2, 1, 4, -1, -2};
        int[] helper = new int[data.length];
        MergeSort ms = new MergeSort();
        ms.mergeSort(data, helper, 0, data.length - 1);
        for (int d : data) {
            System.out.println(d);
        }
    }
}
