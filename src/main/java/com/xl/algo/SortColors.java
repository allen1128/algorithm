package com.xl.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortColors {

    //one pass is possible because there is only 3 possible values in the array, 0 goes the the begining, 2 goes to the end, and 1 stays
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int index = 0;

        while (index <= end){
            if (nums[index] == 0){
                int temp = nums[start];
                nums[start] = nums[index];
                nums[index] = temp;
                start++;
            }

            if (nums[index] == 2){
                int temp = nums[end];
                nums[end] = nums[index];
                nums[index] = temp;
                end--;
                index--;
            }
            index++;
        }

        String s = "   a   b ";
        char[] chars = s.toCharArray();
        System.out.println(s.trim());
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<String>();

        String.join(" ", list);
        Collections.reverse(list);

    }

    public static void main(String[] args){
        SortColors sc = new SortColors();
        int[] nums = {1,2,3};
        sc.sortColors(nums);
    }
}
