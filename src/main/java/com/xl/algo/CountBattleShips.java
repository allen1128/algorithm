package com.xl.algo;

import java.util.ArrayList;
import java.util.List;

public class CountBattleShips {
    /*
    public int countBattleships(char[][] board) {
        int count = 0;
        if (board.length == 0 || board[0].length == 0){
            return count;
        }


        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'X' && !visited[i][j]){
                    count++;
                    helper(board, visited, i, j);
                }
            }
        }
        return count;
    }

    public int[][] move = {{0, 1}, {1, 0},{0, -1},{-1, 0}};
    public void helper(char[][] board, boolean[][] visited, int x, int y){
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'X' || visited[x][y]){
            return;
        }

        visited[x][y] = true;
        for (int i = 0; i < move.length; i++){
            helper(board, visited, x + move[i][0], y + move[i][1]);
        }
    }*/

//    public int numIslands(char[][] grid) {
//        boolean[][] visited = new boolean[grid.length][grid[0].length];
//        int count = 0;
//        for (int i = 0; i < grid.length; i++){
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == 'X' && !visited[i][j]) {
//                    count++;
//                    visit(grid, i, j, visited);
//                }
//            }
//        }
//        return count;
//    }
//
//
//    public int[][] move = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
//
//    public void visit(char[][] grid, int x, int y, boolean[][] visited){
//        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 'X' || visited[x][y]) {
//            return;
//        }
//
//        visited[x][y] = true;
//        for (int i = 0; i < move.length; i++) {
//            visit(grid, x + move[i][0], y + move[i][1], visited);
//        }
//    }
//
//    public int countBattleships(char[][] board) {
//        int count = 0;
//        if (board.length == 0 || board[0].length == 0){
//            return count;
//        }
//
//        for (int i = 0; i < board.length; i++){
//            for (int j = 0; j < board[0].length; j++){
//                if (board[i][j] == 'X' && (i == 0 || board[i-1][j] != 'X') && (j == 0 || board[i][j-1] != 'X')){
//                    count++;
//                }
//            }
//        }
//
//        return count;
//    }

    private int[] father;

    public int findFather(int a) {
        if (father[a] == a) {
            return a;
        }
        return father[a] = findFather(father[a]);
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        if (m == 0 || n == 0 || positions.length == 0 || positions[0].length == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        father = new int[m * n];
        for (int i = 0; i < m*n; i++) {
            father[i] = i;
        }

        int[][] grid = new int[m][n];
        int count = 0;

        for (int i = 0; i < positions.length; i++) {
            if (grid[positions[i][0]][positions[i][1]] != 1) {
                grid[positions[i][0]][positions[i][1]] = 1;
                int neightboring = countNb(grid, positions[i][0], positions[i][1]);
                count = count - neightboring + 1;
            }

            result.add(count);
        }

        return result;
    }

    int[][] move = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};

    public int countNb(int[][] grid, int x, int y) {
        int result = 0;

        for (int i = 0; i < move.length; i++) {
            int newX = x + move[i][0];
            int newY = y + move[i][1];

            if (inBound(newX, newY, grid) && grid[newX][newY] == 1) {
                int nParent = findFather(newX * grid[0].length + newY);
                int oParent = findFather(x * grid[0].length + y);

                if (oParent != nParent) {
                    union(oParent, nParent);
                    result++;
                }
            }
        }

        return result;
    }

    public void union(int x, int y) {
        int parentX = findFather(x);
        int parentY = findFather(y);
        if (parentX != parentY) {
            father[parentX] = parentY;
        }
    }

    public boolean inBound(int x, int y, int[][] grid) {
        return x >= 0 && x < grid.length && y >=0 && y < grid[0].length;
    }

    public static void main(String[] args){
        CountBattleShips cbs = new CountBattleShips();
        System.out.println(cbs.numIslands2(4, 4, new int[][]{{1,2}, {3,3},{3,2},{2,2}}));
    }
}
