package com.xl.algo;

import java.util.ArrayList;
import java.util.List;

public class MedianFinder {
    private List<Integer> data = new ArrayList<>();

    public void addNum(int num) {
        if (data.size() == 0) {
            data.add(num);
            return;
        } else if (data.size() == 1) {
            if (data.get(0) > num) {
                data.add(0, num);
            } else {
                data.add(1, num);
            }
            return;
        }

        int index = search(num);
        data.add(index, num);
    }

    private int search(int num) {
        if (data.size() == 0) {
            return 0;
        }

        int left = 0;
        int right = data.size() - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (data.get(mid) >= num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (data.get(left) > num) {
            return left;
        } else if (data.get(right) > num) {
            return right;
        } else {
            return right + 1;
        }
    }

    public double findMedian() {
        if (data.size() == 0) {
            return 0;
        } else if (data.size() == 1) {
            return data.get(0);
        }

        if (data.size() % 2 == 0) {
            return (data.get(data.size() / 2 - 1) + data.get(data.size() / 2)) / 2.0d;
        } else {
            return data.get(data.size() / 2);
        }
    }
//
//    //if the input is between 0 and 100
//    public int[] data = new int[101];
//    public int count = 0;
//
//    public void addNum1(int num) {
//        data[num]++;
//    }
//
//    public double findMedian2() {
//        int left = 0;
//        int right = 0;
//        if (count % 2 == 1) {
//            left = count /2;
//            right = count /2;
//        }  else {
//            left = count / 2 - 1;
//            right = count / 2;
//        }
//
//        int lcount = 0;
//        int res = 0;
//        int prev = 0;
//        String str = "";
//
//        for (int i = 0; i < data.length; i++) {
//            if (lcount < left && lcount + data[i] >= right ) {
//                res = data[i];
//                break;
//            } else if (lcount == left && lcount + data[i] >= right){
//                res = data[i] + prev;
//                break;
//            }
//
//            lcount += data[i];
//
//            if (data[i] == 0) {
//                prev = data[i];
//            }
//        }
//
//        return res;
//    }



    public static void main(String[] args) {
         MedianFinder obj = new MedianFinder();
        obj.addNum(-1);
        System.out.println(obj.findMedian());
        obj.addNum(-2);
        System.out.println(obj.findMedian());
        obj.addNum(-3);
        System.out.println(obj.findMedian());
        obj.addNum(-4);
        System.out.println(obj.findMedian());
        obj.addNum(-5);
        System.out.println(obj.findMedian());
    }
}
