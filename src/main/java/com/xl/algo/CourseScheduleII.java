package com.xl.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleII {
    //own solution
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> mapAfter = new HashMap<>();
        Map<Integer, Set<Integer>> mapBefore = new HashMap<>();

        int[] pre = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            Set<Integer> setBefore = mapBefore.getOrDefault(prerequisite[0], new HashSet<Integer>());
            Set<Integer> setAfter = mapAfter.getOrDefault(prerequisite[1], new HashSet<Integer>());

            pre[prerequisite[0]]++;
            setBefore.add(prerequisite[1]);
            mapBefore.put(prerequisite[0], setBefore);

            setAfter.add(prerequisite[0]);
            mapAfter.put(prerequisite[1], setAfter);
        }

        List<Integer> taken = new ArrayList<>();
        while(taken.size() != numCourses) {
            int sum = 0;
            for (int i = 0; i < numCourses; i++) {
                if (pre[i] == 0) {
                    sum += helper2(i, mapAfter, mapBefore, taken, pre);
                }
            }

            if (sum == 0 && taken.size() != numCourses) {
                return new int[]{};
            }
        }

        return taken.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int helper2(int num, Map<Integer, Set<Integer>> after, Map<Integer, Set<Integer>> before, List<Integer> taken, int[] pre) {
        if (taken.contains(num)) {
            return 0;
        }

        int sum = 0;
        boolean met = true;
        for (Integer b : before.getOrDefault(num, new HashSet<>())) {
            if (!taken.contains(b)) {
                met = false;
            }
        }

        if (met) {
            taken.add(num);
            sum++;
            for (Integer i : after.getOrDefault(num, new HashSet<>())) {
                pre[i]--;
                sum += helper2(i, after, before, taken, pre);
            }
        }

        return sum;
    }

    public int[] findOrder3(int numCourses, int[][] prerequisites) {
        int[] pre = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            pre[prerequisite[0]]++;
        }

        List<Integer> taken = new ArrayList<>();
        while(taken.size() != numCourses) {
            int sum = 0;
            for (int i = 0; i < numCourses; i++) {
                if (pre[i] == 0) {
                    sum += helper3(i, prerequisites, taken, pre);
                }
            }

            if (sum == 0 && taken.size() != numCourses) {
                return new int[]{};
            }
        }

        return taken.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int helper3(int num, int[][] prerequisites, List<Integer> taken, int[] pre) {
        if (taken.contains(num)) {
            return 0;
        }

        int sum = 0;
        boolean met = true;
        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i][0] == num && !taken.contains((prerequisites[i][1]))) {
                met = false;
            }
        }
        if (met) {
            taken.add(num);
            sum++;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == num && !taken.contains((prerequisites[i][0]))) {
                    sum += helper3(prerequisites[i][0], prerequisites, taken, pre);
                }
            }
        }

        return sum;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] taken = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            taken[index++] = num;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == num) {
                    if (--indegree[prerequisites[i][0]] == 0){
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }
        return (index != numCourses) ? new int[]{} : taken;
    }

    public static void main(String[] args) {
        CourseScheduleII cs = new CourseScheduleII();
        System.out.println(Arrays.toString(cs.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})));
    }
}
