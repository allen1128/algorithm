package com.xl.algo.deepdive.sort;

public class QuickSelect {

    public int solve(int[] data, int k) {
        if (k <= 0 || k > data.length) {
            throw new IllegalArgumentException();
        }
        return quickSelect(data, 0, data.length- 1, data.length - k + 1);
    }

    public int quickSelect(int[] data, int left, int right, int k) {
        int mid = partition(data, left, right);
        if (mid + 1 == k) {
            return data[mid];
        } else if (mid + 1 > k) {
            return quickSelect(data, left, mid - 1, k);
        } else {
            return quickSelect(data, mid + 1, right, k);
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

    public void swap(int[] data, int x, int y) {
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }

    public static void main(String[] args) {
        QuickSelect qs = new QuickSelect();
        int[] data = new int[]{1,2,4,7,5,3, 20}; //1,2,3,4,5,7
        System.out.println(qs.solve(data,2));
    }
}
