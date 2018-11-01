package com.xl.algo.sort;

public class QuickSelect {

    public int partion(int[] data, int left, int right) {
        int pivot = data[right];

        while (left < right) {
            while (left < right && data[left] < pivot) {
                System.out.println("left: " + left + " right:" + right);
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

    public int quickSelect(int[] data, int left, int right, int k) {
        if (left >= right) {
            return data[left];
        }

        int index = partion(data, left, right);

        if (index == k) {
            return data[index];
        } else if (index > k) {
            return quickSelect(data, left, index - 1, k);
        } else {
            return quickSelect(data, index + 1, right, k);
        }
    }

    public static void main(String[] args) {
        QuickSelect qs = new QuickSelect();
        int[] data = new int[]{2, 3, 0, -2, -1, 4, -3, 1,5,55,-1};
        System.out.println("value: " + qs.quickSelect(data, 0, data.length - 1, 7));
    }
}
