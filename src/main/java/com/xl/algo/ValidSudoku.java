package com.xl.algo;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] markedX = new int[9];
            int[] markedY = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int pos = board[i][j] - '0' -1;
                    if (markedX[pos] != 0) {
                        return false;
                    }
                    markedX[pos] = 1;
                }

                if (board[j][i] != '.') {
                    int pos = board[j][i] - '0' -1;
                    if (markedY[pos] != 0) {
                        return false;
                    }
                    markedY[pos] = 1;
                }
            }
        }

        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                if (isSubBoxInvalidSudoku(board, i, j, i+3, j+3)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isSubBoxInvalidSudoku(char[][] board, int x, int y, int x2, int y2) {
        int[] marked = new int[9];
        for (int i = x; i < x2; i++) {
            for (int j = y; j < y2; j++) {
                if (board[i][j] != '.') {
                    int pos = board[i][j] - '0' -1;
                    if (marked[pos] != 0) {
                        return true;
                    }
                    marked[pos] = 1;
                }

            }
        }
        return false;
    }


    public boolean isValidSudoku2(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            //check row
            if (!verify(board, i, 0, i, board[i].length - 1)) {
                return false;
            }

            //check column
            if (!verify(board, 0, i, board[i].length - 1, i)) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i+=3) {
            for (int j = 0; j < board[0].length; j+=3) {
                if (!verify(board, i, j, i + 2, j + 2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean verify(char[][] board, int x1, int y1, int x2, int y2) {
        int[] number = new int[10];

        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (number[board[i][j] - '0'] != 0) {
                    return false;
                }

                number[board[i][j] - '0']  = 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku vsd = new ValidSudoku();
        char[][] grid = new char[][]{
                {'.','.','4','.','.','.','6','3','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},
                {'4','.','3','.','.','.','.','.','1'},
                {'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}};
        System.out.println(vsd.isValidSudoku2(grid));
    }
}
