package com.xl.algo;

public class TicTacToe {
    /** Initialize your data structure here. *//*
    public int[][] board;
    public TicTacToe(int n) {
        board = new int[n][n];
    }

    *//** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. *//*

    public int diagnolWin1(int row, int col, int player){
        int lrow = row;
        int lcol = col;
        int count = 0;

        while (lrow >= 0 && lcol >= 0){
            if (board[lrow--][lcol--] != player){
                return -1;
            }
            count++;
        }

        lrow = row;
        lcol = col;

        while (lrow < board.length && lcol < board.length){
            if (board[lrow++][lcol++] != player){
                return -1;
            }
            count++;
        }

        if (count == board.length + 1){
            return player;
        } else {
            return -1;
        }
    }

    public int diagnolWin2(int row, int col, int player){
        int lrow = row;
        int lcol = col;
        int count = 0;

        while (lrow >= 0 && lcol < board.length){
            if (board[lrow--][lcol++] != player){
                return -1;
            }
            count++;
        }

        lrow = row;
        lcol = col;

        while (lrow < board.length && lcol >= 0){
            if (board[lrow++][lcol--] != player){
                return -1;
            }
            count++;
        }

        if (count == board.length + 1){
            return player;
        } else {
            return -1;
        }

    }

    public int horizontalWin(int row, int player){
        for (int i = 0; i < board.length; i++){
            if (board[row][i] != player){
                return -1;
            }
        }

        return player;
    }

    public int verticalWin(int col, int player){
        for (int i = 0; i < board.length; i++){
            if (board[i][col] != player){
                return -1;
            }
        }

        return player;
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;
        return diagnolWin1(row, col, player) == player ||
                diagnolWin2(row, col, player) == player ||
                horizontalWin(row, player) == player ||
                verticalWin(col, player) == player ? player : 0;
    }*/

    //to record the number of move a player has made on a given row. if both player makes move on the same row,
    // the count is cancelled out. 1 for player 1, -1 for player 2.
    //how to check if a move is made on the antidiagnoal path: row == size - col - 1;
    public int[] rows;
    public int[] cols;
    public int diagonal = 0;
    public int antiDiagonal = 0;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */



    public int move(int row, int col, int player) {
        int score = player == 1 ? 1 : -1;

        rows[row] += score;
        cols[col] += score;

        if (row == col){
            diagonal += score;
        }

        if (row == rows.length - col - 1){
            antiDiagonal += score;
        }

        int size = rows.length;
        if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size ||
                Math.abs(diagonal) == size || Math.abs(antiDiagonal) == size){
            return player;
        } else {
            return 0;
        }
    }

    public static void main(String[] args){
        TicTacToe ttt = new TicTacToe(2);
        System.out.println(ttt.move(0, 0, 1));
        System.out.println(ttt.move(0, 1, 2));
        System.out.println(ttt.move(1, 1, 1));
    }
}
