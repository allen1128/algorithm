package com.xl.algo;

public class IsValidSudoku {
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
}
