package com.xl.algo.deepdive.sort;

import java.util.Arrays;

public class HeapSort {
    public static void heapify(int[] elems, int count, int i) {
        while (true) {
            int maxPos = i;
            maxPos = i * 2 + 1 <= count && elems[i * 2 + 1] > elems[i]
                    ? i * 2 + 1
                    : maxPos;
            maxPos = (i * 2 + 2) <= count && elems[i * 2 + 2] > elems[maxPos]
                    ? i * 2 + 2
                    : maxPos;
            if (maxPos == i) {
                break;
            }
            swap(elems, i, maxPos);
            i = maxPos;
        }
    }

    public static void swap(int[] elements, int x, int y) {
        int temp = elements[x];
        elements[x] = elements[y];
        elements[y] = temp;
    }

    public static void buildHeap(int[] elems) {
        for (int i = (elems.length - 1) / 2; i >= 0; i--) {
            heapify(elems, elems.length - 1, i);
        }
    }

    public static void sort(int[] elems) {
        buildHeap(elems);

        for (int i = elems.length - 1; i > 0; i--) {
            swap(elems, 0, i);
            heapify(elems, i - 1, 0);
        }
    }

    public static void main(String[] args) {
        int[] elements = new int[]{56, 100, 7, 8, 34, 6, 7, 1, 8, 9, 2, 2, -2};
        HeapSort.sort(elements);
        System.out.println(Arrays.toString(elements));
    }
}
