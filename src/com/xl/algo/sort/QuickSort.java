package com.xl.algo.sort;

public class QuickSort {

    public static int count = 0;
    public void split(int[] data, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = sort(data, left, right);
        System.out.println("index=" + index);
        split(data, left, index - 1);
        split(data, index + 1, right);
    }

    public int sort(int[] data, int left, int right) {
        int pivot = data[right];

        while (left < right) {
            while (data[left] < pivot && left < right) {
                left++;
            }
            if (left < right) {
                swap(data, left, right--);
            }
            while (data[right] > pivot && left < right) {
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
        count++;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();

        int[] data = new int[]{2, -6, -1, 3, 0};
        qs.split(data, 0, data.length - 1);

        for (int d : data) {
            System.out.println(d);
        }
        System.out.println("total amount of swap=" + count);
    }
}
