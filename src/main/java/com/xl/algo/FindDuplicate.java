package com.xl.algo;

import static java.lang.Thread.sleep;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            System.out.println("slow: " + slow);
            System.out.println("fast: " + fast);
        }

        fast = 0; //fast = nums[0] this is wrong as it would mean fast is one step ahead of slow
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
            System.out.println("slow: " + slow);
            System.out.println("fast: " + fast);
        }

        return slow;
    }

    public static void main(String[] args) {
        FindDuplicate fd = new FindDuplicate();
        fd.findDuplicate(new int[]{1,2,4,4,3});
    }
}
