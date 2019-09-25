package com.xl.algo;

import java.util.PriorityQueue;

public class MaxAreas {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j]) {
                    max = Math.max(max, visit(grid, i, j, visited));
                }
            }
        }
        return max;
    }

    public int[][] steps = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int visit(int[][] grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;

        if (grid[i][j] == 0) {
            return 0;
        }

        int count = 1;
        for (int u = 0; u < steps.length; u++) {
            if (isValid(i + steps[u][0], j + steps[u][1], grid, visited)) {
                count += visit(grid, i + steps[u][0], j + steps[u][1], visited);
            }
        }
        return count;
    }

    public boolean isValid(int i, int j, int[][] grid, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] != 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MaxAreas ma = new MaxAreas();
        int[][] grid = {{0,1,0,0,1,1,0,0,1,0,1,0,0}, {0,1,0,0,1,1,0,0,1,1,1,0,0}, {0,0,0,0,0,0,0,0,0,0,1,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(ma.maxAreaOfIsland(grid));
    }
}
