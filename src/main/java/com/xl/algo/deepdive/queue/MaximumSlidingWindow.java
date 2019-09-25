package com.xl.algo.deepdive.queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaximumSlidingWindow {
    public List<Integer> solve(int[] data, int k) {
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            while (deque.size() != 0 && deque.peekLast() <= i - k) {
                deque.pollLast();
            }

            while (deque.size() != 0 && data[deque.peekFirst()] <= data[i]) {
                deque.pollFirst();
            }

            deque.addFirst(i);

            if (i >= k - 1) {
                result.add(data[deque.peekLast()]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumSlidingWindow msw = new MaximumSlidingWindow();
        System.out.println(msw.solve(new int[] {1,3,-1,-3,5,3,6,7}, 3));
    }
}
