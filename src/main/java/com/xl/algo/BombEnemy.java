package com.xl.algo;

import java.util.Arrays;

public class BombEnemy {
//    public int[][][] memo;
//
//    public int helper(char[][] grid, int x, int y, int d) {
//        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
//            return 0;
//        }
//
//        if (memo[x][y][d] != -1) {
//            return memo[x][y][d];
//        }
//        if (grid[x][y] == 'W') {
//            memo[x][y][d] = 0;
//        } else {
//            switch (d) {
//                case 0:
//                    memo[x][y][d] = grid[x][y] == 'E' ? 1 : 0 + helper(grid, x, y - 1, d);
//                    break;
//                case 1:
//                    memo[x][y][d] = grid[x][y] == 'E' ? 1 : 0 + helper(grid, x, y + 1, d);
//                    break;
//                case 2:
//                    memo[x][y][d] = grid[x][y] == 'E' ? 1 : 0 + helper(grid, x - 1, y, d);
//                    break;
//                case 3:
//                    memo[x][y][d] = grid[x][y] == 'E' ? 1 : 0 + helper(grid, x + 1, y, d);
//                    break;
//            }
//        }
//
//        return memo[x][y][d];
//    }
//
//    public int maxKilledEnemies(char[][] grid) {
//        if (grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//        int max = 0;
//        memo = new int[grid.length][grid[0].length][4];
//        for (int[][] d0 : memo) {
//            for (int[] d1 : d0) {
//                Arrays.fill(d1, -1);
//            }
//        }
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == '0' && memo[i][j][0] == -1) {
//                    memo[i][j][0] = helper(grid, i, j, 0);
//                    memo[i][j][1] = helper(grid, i, j, 1);
//                    memo[i][j][2] = helper(grid, i, j, 2);
//                    memo[i][j][3] = helper(grid, i, j, 3);
//                    int lmax = memo[i][j][0] + memo[i][j][1] + memo[i][j][2] + memo[i][j][3];
//                    if (lmax > max) {
//                        max = lmax;
//                    }
//                }
//            }
//        }
//        return max;
//    }

    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] killed = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            int count = 0;
            int j = 0;
            for (; j < grid[0].length; j++) {
                if (grid[i][j] == 'E') {
                    count++;
                } else if (grid[i][j] == 'W') {
                    count = 0;
                } else if (grid[i][j] == '0') {
                    killed[i][j] = count;
                }
            }
            count = 0;
            j = grid[0].length - 1;
            for (; j >= 0; j--) {
                if (grid[i][j] == 'E') {
                    count++;
                } else if (grid[i][j] == 'W') {
                    count = 0;
                } else if (grid[i][j] == '0') {
                    killed[i][j] += count;
                }
            }
        }
        int max = 0;
        for (int j = 0; j < grid[0].length; j++) {
            int count = 0;
            int i = 0;
            for (; i < grid.length; i++) {
                if (grid[i][j] == 'E') {
                    count++;
                } else if (grid[i][j] == 'W') {
                    count = 0;
                } else if (grid[i][j] == '0') {
                    killed[i][j] += count;
                }
            }

            count = 0;
            i = grid.length -  1;
            for (; i >= 0; i--) {
                if (grid[i][j] == 'E') {
                    count++;
                } else if (grid[i][j] == 'W') {
                    count = 0;
                } else if (grid[i][j] == '0') {
                    killed[i][j] += count;
                    max = Math.max(killed[i][j], max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BombEnemy be = new BombEnemy();
        char[][] grids = new char[][]{{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}};
        System.out.println(be.maxKilledEnemies(grids));
    }
}
