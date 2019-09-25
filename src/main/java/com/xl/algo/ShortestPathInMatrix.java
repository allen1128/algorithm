package com.xl.algo;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInMatrix {
    public class Pos {
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 ||
                grid[0].length == 0 || grid[0][0] == 1 ||
                grid[grid.length-1][grid.length-1] == 1) {
            return -1;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 0));
        int len = 1;
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pos pos = queue.poll();
                if (pos.x == grid.length - 1 && pos.y == grid[0].length - 1) {
                    return len;
                }


                for (int j = 0; j < moves.length; j++) {
                    int newx = pos.x + moves[j][0];
                    int newy = pos.y + moves[j][1];

                    if (isValid(newx, newy, grid, visited)) {
                        Pos p = new Pos(newx, newy);
                        queue.add(p);
                        visited[p.x][p.y] = true;
                    }
                }
            }
            len++;
        }
        return -1;
    }

    int[][] moves = new int[][] {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};

    public boolean isValid(int x, int y, int[][] grid, boolean[][] visited) {
        return (x >= 0 && x < grid.length && y >= 0 && y < grid.length && !visited[x][y] && grid[x][y] == 0);
    }

    public static void main(String[] args) {
        ShortestPathInMatrix sp = new ShortestPathInMatrix();
        System.out.println(sp.shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
    }
}
