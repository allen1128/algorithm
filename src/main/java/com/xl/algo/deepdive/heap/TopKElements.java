package com.xl.algo.deepdive.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopKElements {

    public List<Integer> top(int[] data, int k) {
        Heap<Integer> maxHeap = new Heap<>(data.length, ((o1, o2) -> o1.compareTo(o2)));
        List<Integer> list = new ArrayList<>();

        Arrays.stream(data).forEach(d -> {
            if (maxHeap.getCount() < k) {
                maxHeap.insert(d);
            } else if (maxHeap.peek() < d) {
                maxHeap.pop();
                maxHeap.insert(d);
            }
        });

        for (int i = 0; i < k; i++){
            list.add(maxHeap.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        TopKElements tke = new TopKElements();
        System.out.println(tke.top(new int[] {56, 100, 7, 8, 34, 6, 7, 1, 8, 9, 2, 2, -2}, 3));
    }
}
