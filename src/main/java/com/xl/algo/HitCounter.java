package com.xl.algo;

import java.util.ArrayList;
import java.util.List;

public class HitCounter {

//    public static class TSCount {
//        public int timestamp;
//        public int count;
//        public TSCount(int ts, int c) {
//            timestamp = ts;
//            count = c;
//        }
//
//    }
//    private List<TSCount> counts = new ArrayList<>();
//
//    /** Initialize your data structure here. */
//    public HitCounter() {
//    }
//
//    /** Record a hit.
//     @param timestamp - The current timestamp (in seconds granularity). */
//    public void hit(int timestamp) {
//        if (counts.size() == 0) {
//            counts.add(new TSCount(timestamp, 1));
//            return;
//        }
//
//        TSCount tsCount = counts.get(counts.size() - 1);
//        if (tsCount != null && tsCount.timestamp == timestamp) {
//            tsCount.count++;
//        } else if (counts.size() == 0){
//            counts.add(new TSCount(timestamp, 1));
//        } else {
//            counts.add(new TSCount(timestamp, counts.get(counts.size() - 1).count + 1));
//        }
//    }
//
//    /** Return the number of hits in the past 5 minutes.
//     @param timestamp - The current timestamp (in seconds granularity). */
//    public int getHits(int timestamp) {
//        int hits = 0;
//        if (counts.size() == 0) {
//            return hits;
//        }
//
//        int beginIndex = findIndex(timestamp-300);
//        int endIndex = findIndex(timestamp);
//
//        if (beginIndex == -1) {
//            beginIndex = 0;
//            hits = counts.get(0).count;
//        }
//        hits += counts.get(endIndex).count - counts.get(beginIndex).count;
//        return hits;
//    }
//
//    //find the timestamp <= given timestamp.
//    public int findIndex(int timestamp) {
//        if (timestamp <= 0) {
//            return -1;
//        }
//
//        int index = 0;
//        int left = 0;
//        int right = counts.size() - 1;
//
//        while (left + 1 < right) {
//            int mid = left + (right - left)/2;
//            if (counts.get(mid).timestamp > timestamp) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//
//        if (counts.get(right).timestamp <= timestamp) {
//            index = right;
//        } else if (counts.get(left).timestamp <= timestamp){
//            index = left;
//        } else { //if left.timestamp > timestamp
//            index = left - 1;
//        }
//
//        return index;
//    }

    private int[] times;
    private int[] hits;
    /** Initialize your data structure here. */
    public HitCounter() {
        times = new int[300];
        hits = new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                total += hits[i];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        HitCounter hc = new HitCounter();
        hc.hit(605);
        hc.hit(605);
        hc.hit(605);
        System.out.println(hc.getHits(6));
        hc.hit(606);
        System.out.println(hc.getHits(607));
    }
}

