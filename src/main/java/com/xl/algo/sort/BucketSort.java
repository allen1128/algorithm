package com.xl.algo.sort;

public class BucketSort {

    public void sort(int[] data, int max) {
        int[] buckets = new int[max + 1];

        for (int i = 0; i < data.length; i++) {
            buckets[data[i]]++;
        }

        for (int i = 1; i < max + 1; i++) {
            buckets[i] = buckets[i - 1] + buckets[i]; //calculate the future index after partition
        }

        int[] temp = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i]; //buffer original data
        }

        for (int i = 0; i < data.length; i++) {
            data[--buckets[temp[i]]] = temp[i]; //assign value to the future index in data array.
        }

//        int index = 0;
//        for (int i = 0; i < max + 1; i++) {
//            for (int j = 0; j < buckets[i]; j++) {
//                data[index++] = i;
//            }
//        }
    }

    public static void main(String[] args) {
        BucketSort bs = new BucketSort();
        int[] data = new int[]{22, 11, 23, 10, 5};
        bs.sort(data, 23);
        for (int d : data) {
            System.out.println(d);
        }
    }
}
