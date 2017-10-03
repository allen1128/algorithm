package com.xl.algo;

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

    public int countBattleships(char[][] board) {
        int count = 0;
        if (board.length == 0 || board[0].length == 0){
            return count;
        }

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'X' && (i == 0 || board[i-1][j] != 'X') && (j == 0 || board[i][j-1] != 'X')){
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args){
        CountBattleShips cbs = new CountBattleShips();
        char[][] board = {{'X','.','X'},{'.','.','X'},{'.','.','X'}};
        System.out.println(cbs.countBattleships(board));
    }
}
