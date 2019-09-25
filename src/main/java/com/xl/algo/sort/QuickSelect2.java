package com.xl.algo.sort;

public class QuickSelect2 {
    public int quickSelect(int[] data, int k) {
        return split(data, 0, data.length - 1, data.length - k + 1);
    }
    public int split(int[] data, int left, int right, int k) {
        int mid = partition(data, left, right);
        if (mid + 1 == k) {
            return data[mid];
        } else if (mid + 1 < k) {
            return split(data, mid + 1, right, k);
        } else {
            return split(data, left, mid - 1, k);
        }
    }
    public int partition(int[] data, int left, int right) {
        int pivot = data[right];
        while (left < right) {
            while (left < right && data[left] < pivot) {
                left++;
            }
            if (left < right) {
                swap(data, left, right--);
            }
            while (left < right && data[right] > pivot) {
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
        QuickSelect2 qs2 = new QuickSelect2();
        int[] data = new int[] {2, 3, 1, 0, 6, 7,4,5};
        System.out.println(qs2.quickSelect(data, 8));
    }
}
