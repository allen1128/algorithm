package com.xl.algo.search;

import java.util.HashSet;
import java.util.Set;

public class BinarySearch {
    public int searchRecu(int[] data, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        if (target > data[mid]) {
            return searchRecu(data, mid + 1, right, target);
        } else if (target == data[mid]) {
            return mid;
        } else {
            return searchRecu(data, left, mid - 1, target);
        }
    }

    public int searchIter(int[] data, int left, int right, int target) {
        while (left + 1 < right) {
            int mid =left + (right - left) /2;
            if (data[mid] == target) {
                return mid;
            } else if (data[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (data[left] == target) {
            return left;
        } else if (data[right] == target) {
            return right;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.searchIter(new int[]{1, 2, 5, 6}, 0, 3, 4));

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(10);

    }
}
