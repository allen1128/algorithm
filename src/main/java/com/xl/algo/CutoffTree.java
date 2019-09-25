package com.xl.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CutoffTree {
    //Dfs solution // DO not work // keep it to remind the thought process

//    int[][] steps = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
//    boolean[][] visited = null;
//
//    public int cutOffTree(List<List<Integer>> forest) {
//        if (forest == null || forest.size() == 0 || forest.get(0).size() == 0) {
//            return 0;
//        }
//        visited = new boolean[forest.size()][forest.get(0).size()];
//        int countTree = 0;
//        for (int i = 0; i < forest.size(); i++) {
//            for (int j = 0; j < forest.get(i).size(); j++) {
//                if (forest.get(i).get(j) > 1) {
//                    countTree++;
//                }
//            }
//        }
//        return helper(-1, 0, 0, forest, countTree, 0);
//    }
//
//
//    public int helper(int prev, int row, int col, List<List<Integer>> forest, int countTree, int step) {
//        visited[row][col] = true;
//        int val = forest.get(row).get(col);
//        if (val == 1) {
//            step++;
//        } else if (val <= prev || val == 0) {
//            return -1;
//        } else if (val > 1) {
//            countTree--;
//            step++;
//            prev = val;
//        }
//
//        if (countTree == 0) {
//            return step - 1;
//        }
//
//        for (int i = 0; i < steps.length; i++) {
//            int newrow = row + steps[i][0];
//            int newcol = col + steps[i][1];
//            if (isValid(newrow, newcol, forest)) {
//                int res = helper(prev, newrow, newcol, forest, countTree, step);
//                if (res != -1) {
//                    return res;
//                }
//            }
//        }
//        visited[row][col] = false;
//        return -1;
//    }
//
//    public boolean isValid(int newrow, int newcol, List<List<Integer>> forest) {
//        if (newrow < 0 || newcol < 0 || newrow >= forest.size() || newcol >= forest.get(0).size() || visited[newrow][newcol]) {
//            return false;
//        }
//        return true;
//    }

    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();

        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }
        trees.sort((a, b) -> Integer.compare(a[2], b[2])); //partition tree in ascending order according to the value
        int sum = 0;
        int[] start = new int[2]; //starting from [0,0]

        for (int i = 0; i < trees.size(); i++) {
            int step = dist(start[0], start[1], trees.get(i)[0], trees.get(i)[1], forest);
            if (step == -1) {
                return -1;
            } else {
                sum += step;
            }
            start[0] = trees.get(i)[0];
            start[1] = trees.get(i)[1];
        }
        return sum;
    }

    int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    private int dist(int s1, int s2, int e1, int e2, List<List<Integer>> forest) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {s1, s2});
        int count = 0;

        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        visited[s1][s2] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] start = queue.poll();
                if (start[0] == e1 && start[1] == e2) {
                    return count;
                } else {
                    for (int j = 0; j < dir.length; j++) {
                        int newx = start[0] + dir[j][0];
                        int newy = start[1] + dir[j][1];
                        if (isValid(newx, newy, forest, visited)) {
                            queue.add(new int[]{newx, newy});
                            visited[newx][newy] = true;
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public boolean isValid(int newx, int newy, List<List<Integer>> forest, boolean[][] visited) {
        if (newx < 0 || newy < 0 || newx >= forest.size() || newy >= forest.get(0).size() || visited[newx][newy] || forest.get(newx).get(newy) == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CutoffTree cof = new CutoffTree();
        List<List<Integer>> forest = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);l1.add(2);l1.add(4);
        forest.add(l1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(9);l2.add(8);l2.add(6);
        forest.add(l2);
        List<Integer> l3 = new ArrayList<>();
        l3.add(10);l3.add(7);l3.add(5);
        forest.add(l3);

        System.out.println(cof.cutOffTree(forest));

    }
}
