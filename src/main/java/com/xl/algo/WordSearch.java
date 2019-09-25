package com.xl.algo;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return false;
        }

        char c = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == c) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    visited[i][j] = true;
                    if (helper(board, i, j, word, 1, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public int[][] steps = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public boolean ans;

    public boolean helper(char[][] board, int x, int y, String word, int index, boolean[][] visited) {
        if (index >= word.length() || ans) {
            ans = true;
            return true;
        }

        for (int i = 0; i < steps.length; i++) {
            int lx = x + steps[i][0];
            int ly = y + steps[i][1];
            if (isValid(board, lx, ly, visited) && board[lx][ly] == word.charAt(index)) {
                visited[lx][ly] = true;
                helper(board, lx, ly, word, index+1, visited);
                visited[lx][ly] = false;
            }
        }

        return false;
    }

    public boolean isValid(char[][] board, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return false;
        } else {
            return true;
        }
    }
    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(ws.exist(board, "ABCCED"));
    }
}
