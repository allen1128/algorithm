package com.xl.algo.sort;

import java.util.Arrays;

public class QuickSort2 {
    public void quicksort(int[] data) {
        split(data, 0, data.length - 1);
    }
    public void split(int[] data, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(data, left, right);
        split(data, left, mid - 1);
        split(data, mid + 1, right);
    }
    public int partition(int[] data, int left, int right) {
        int pivot = data[right];
        while (left < right) {
            while (data[left] < pivot && left < right) {
                left++;
            }
            if (left < right) {
                swap(data, left, right--);
            }
            while(data[right] > pivot && left < right) {
                right--;
            }
            if (left < right) {
                swap(data, left++, right);
            }
        }
        return left;
    }

    public void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort2 qs2 = new QuickSort2();
        int[] data = new int[]{-1, 2, 5, -6, -7, -2, -5};
        qs2.quicksort(data);
        System.out.println(Arrays.toString(data));
    }
}
