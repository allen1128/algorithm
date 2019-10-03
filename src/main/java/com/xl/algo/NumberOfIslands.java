package com.xl.algo;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    traverse(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    int[][] moves = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    private void traverse(char[][] grid, int i, int j) {
        if (!valid(grid, i, j)) {
            return;
        }
        grid[i][j] = '0';
        for (int x = 0; x < moves.length; x++) {
            traverse(grid, i+moves[x][0], j+moves[x][1]);
        }
    }

    private boolean valid(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NumberOfIslands noi = new NumberOfIslands();
        char[][] grids = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(noi.numIslands(grids));
    }
}
