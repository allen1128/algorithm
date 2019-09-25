package com.xl.algo;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindKLargest {
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            if (queue.size() == k) {
                int n = queue.peek();
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
        System.out.println(FindKLargest.findKthLargest(new int[]{2,3,5,6,1,100,-2,0,-5,-6,7}, 5));
    }
}
