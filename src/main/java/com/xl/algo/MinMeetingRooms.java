package com.xl.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MinMeetingRooms {
    public static class Interval {
        int start;
        int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        Set<Interval> visited = new HashSet<>();

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1.start > o2.start) {
                return 1;
            } else {
                return -1;
            }
        });


        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (visited.contains(intervals[i])) {
                continue;
            }

            count++;
            visited.add(intervals[i]);
            int end = intervals[i].end;

            for (int j = i + 1; j < intervals.length; j++) {
                if (visited.contains(intervals[j])) {
                    continue;
                }

                if (intervals[j].start >= end) {
                    visited.add(intervals[j]);
                    end = intervals[j].end;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[] {
                new Interval(1, 5),
                new Interval(8, 9),
                new Interval(8, 9)
        };
        MinMeetingRooms mmr = new MinMeetingRooms();
        System.out.println(mmr.minMeetingRooms(intervals));
    }
}
