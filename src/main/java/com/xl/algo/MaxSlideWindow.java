package com.xl.algo;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlideWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }

        Deque<Integer> deque = new LinkedList<>();

        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {

            if (deque.size() > 0 && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            while (deque.size() > 0 && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.add(i);

            if (i >= k - 1) {
                result[i + 1 - k] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
