package com.xl.algo.sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QuickSelect {

    public int partion(int[] data, int left, int right) {
        int pivot = data[right];

        while (left < right) {

            //find a element in left larger than pivot
            while (left < right && data[left] < pivot) {
                System.out.println("left: " + left + " right:" + right);
                left++;
            }

            //found, swap with right;
            if (left < right) {
                swap(data, left, right--);
            }

            //find element in right smaller than pivot
            while (left < right && data[right] > pivot) {
                right--;
            }

            if (left < right) {
                swap(data, left++, right);
            }
        }

        data[left] = pivot;
        return left;
    }

    public int partion2(int[] data, int left, int right) {
        int pivot = data[right];

        while (left < right) {

            //find a element in left larger than pivot
            while (left < right && data[left] < pivot) {
                System.out.println("left: " + left + " right:" + right);
                left++;
            }

            //find element in right smaller than pivot
            while (left < right && data[right] >= pivot) {
                right--;
            }

            if (left < right) {
                System.out.println("swaping left v: " + data[left] + " right v:" + data[right]);
                swap(data, left++, right--);
            }
        }

        data[left] = pivot;
        return left;
    }
    public void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public int helper(int[] data, int left, int right, int k) {
        int index = partion(data, left, right);

        if (index + 1 == k) {
            return data[index];
        } else if (index + 1 > k) {
            System.out.println("go left with l:" + left + " r: " + (index - 1));
            return helper(data, left, index - 1, k);
        } else {
            System.out.println("go right with l:" + (index + 1) + " r:" + right);
            return helper(data, index + 1, right, k);
        }
    }

    public int quickSelect(int[] data, int k) {
        if (k > data.length) {
            return Integer.MAX_VALUE;
        }
        return helper(data, 0, data.length - 1, data.length - k + 1); //bottom
    }

    public int quickSelect2(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            if (queue.size() == k) {
                Integer n = queue.peek();
                if (n < num) {
                    queue.poll();
                    queue.offer(num);
                }
            } else {
                queue.offer(num);
            }
        }

        return queue.poll();

    }

    public static void main(String[] args) {
        QuickSelect qs = new QuickSelect();
        int[] data = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println("value: " + qs.quickSelect2(data, 9)); //top k largest
    }
}
