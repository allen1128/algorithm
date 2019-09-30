package com.xl.algo.deepdive.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindMedian {
    public static List<Double> find(int[] data) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        //elements in minQueue are greater than ones in maxQueue.

        List<Double> medians = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (i == 0) {
                maxQueue.offer(data[i]);
                medians.add(Double.valueOf(maxQueue.peek()));
            } else if (i % 2 == 0) { //same number, add to max
                if (maxQueue.peek() >= data[i]) {
                    maxQueue.offer(data[i]);
                } else {
                    maxQueue.offer(minQueue.poll());
                    minQueue.offer(data[i]);
                }
                medians.add(Double.valueOf(maxQueue.peek()));
            } else { //max has one more item than min, add to min
                if (maxQueue.peek() <= data[i]) {
                    minQueue.offer(data[i]);
                } else {
                    minQueue.offer(maxQueue.poll());
                    maxQueue.offer(data[i]);
                }
                medians.add(Double.valueOf(maxQueue.peek() + minQueue.peek())/2);
            }
        }

        return medians;
    }

    public static void main(String[] args) {
        System.out.println(FindMedian.find(new int[]{1, 2, 3, 4, 5}));
    }
}
