package com.xl.algo.deepdive.sort;

import java.util.Arrays;

public class QuickSort {

    public void quickSort(int[] data, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(data, left, right);
        quickSort(data, left, index - 1);
        quickSort(data, index + 1, right);
    }

    private int partition(int[] data, int left, int right) {
        //use a element as the pivotal
        int pivotal = data[right];
        //move all eles less than pival to its left and the greater ones to its right
        while (left < right) {
            while (left < right && data[left] <= pivotal) {
                left++;
            }
            if (left < right) {
                swap(data, left, right--);
            }
            while (left < right && data[right] >= pivotal) {
                right--;
            }
            if (left < right) {
                swap(data, left++, right);
            }
        }

        //return the partion point
        return left;
    }

    private void swap(int[] data, int x, int y) {
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }


    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] data = new int[]{-1, 2, 5, -6, -7, -2, -5};
        qs.quickSort(data, 0, 6);
        System.out.println(Arrays.toString(data));
    }
}
