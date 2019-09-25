package com.xl.algo.search;

public class MatrixSearch {
    public class Pos{
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public Pos search(int[][] max, int target)  {
        int x = 0;
        int y = max[0].length - 1;

        while (x < max.length && y >= 0) {
            if (max[x][y] > target) {
                y--;
            } else if (max[x][y] < target) {
                x++;
            } else {
                return new Pos(x, y);
            }
        }

        return new Pos(-1, -1);

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{new int[]{1,2,3,4}, new int[]{2,3,5,7}};
        MatrixSearch ms = new MatrixSearch();
        Pos pos = ms.search(matrix, 5);
        System.out.println(String.format("x=%s, y=%s", pos.x, pos.y));
    }
}
