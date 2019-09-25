package com.xl.algo.search;

import java.text.SimpleDateFormat;

public class StartEndPosGivenANumber {
    private static int leftMost;
    private static int rightMost;

    public void search(int[] data, int num) {
        int left = 0;
        int right = data.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (data[mid] > num) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (data[right] == num) {
            rightMost = right;
        } else if (data[left] == num) {
            rightMost = left;
        } else {
            return;
        }


        left = 0;
        right = data.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (data[mid] >= num) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (data[left] == num) {
            leftMost = left;
        } else if (data[right] == num) {
            leftMost = right;
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        StartEndPosGivenANumber sep = new StartEndPosGivenANumber();
        sep.search(new int[]{2, 2, 3, 3, 3, 3, 4, 5, 10}, 3);
        System.out.println("leftMost:" + String.valueOf(leftMost) + ", rightMost: " + String.valueOf(rightMost));
    }
}
