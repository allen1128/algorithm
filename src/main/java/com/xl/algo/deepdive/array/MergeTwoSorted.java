package com.xl.algo.deepdive.array;

import java.util.Arrays;

public class MergeTwoSorted {
    public int[] merge(int[] one, int[] another) {
        one = Arrays.copyOf(one, one.length + another.length);
        int end1 = one.length - another.length - 1;
        int end2 = another.length - 1;

        int end = one.length - 1;
        while(end1 >= 0 && end2 >= 0) {
            if (one[end1] > another[end2]) {
                one[end--] = one[end1--];
            } else {
                one[end--] = another[end2--];
            }
        }
        while (end1 >= 0) {
            one[end--] = one[end1--];
        }

        while (end2 >= 0) {
            one[end--] = another[end2--];
        }

        return one;
    }

    public static void main(String[] args) {
        MergeTwoSorted mts = new MergeTwoSorted();
       System.out.println(Arrays.toString(mts.merge(new int[] {1, 5, 117, 119}, new int[]{11, 16, 17})));
    }
}
