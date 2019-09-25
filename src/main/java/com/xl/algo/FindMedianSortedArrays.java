package com.xl.algo;

public class FindMedianSortedArrays {
    public double helper(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (nums1.length > nums2.length) {
            return helper(nums2, start2, nums1, start1, k);
        }

        //watchpoint 2
        // if one array is empty, return theOtherArray[k-1]

        if (start1 == nums1.length) {
            return nums2[k - 1];
        } else if (start2 == nums2.length) {
            return nums1[k - 1];
        }


        //watch point 2
        //if k = 1, return the array with small value.
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        //watchpoint 3
        //pa and pb is the delta to be added on top of start1 and start2
        int pa = Math.min(k / 2, nums1.length - start1);
        int pb = k - pa;

        if (nums1[start1 + pa - 1] <= nums2[start2 + pb - 1]) {
            return helper(nums1, start1 + pa, nums2, start2, k - pa);
        } else {
            return helper(nums1, start1, nums2, start2 + pb, k - pb);
        }
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;

        if (total % 2 == 0) {
            double x = helper(nums1, 0, nums2, 0, total / 2);
            System.out.println("x: " + x);
            double y = helper(nums1, 0, nums2, 0, total / 2 + 1);
            System.out.println("y: " + y);
            return (x + y) / 2;
        } else {
            return helper(nums1, 0, nums2, 0, total / 2 + 1);
        }
    }

    public static void main(String[] args) {
        FindMedianSortedArrays fm = new FindMedianSortedArrays();
        System.out.println(fm.findMedianSortedArrays(new int[]{2}, new int[]{2, 3}));
    }
}
