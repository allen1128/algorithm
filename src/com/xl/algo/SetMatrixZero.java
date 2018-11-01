package com.xl.algo;

import java.util.Stack;

public class SetMatrixZero {
    class Pos {
        int x;
        int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return;
        }

        boolean[] visitedRow = new boolean[matrix.length];
        boolean[] visitedCol = new boolean[matrix[0].length];

        Stack<Pos> stack = new Stack<>();
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    stack.push(new Pos(i,j));
                }
            }
        }

        while(!stack.isEmpty()){
            Pos pos = stack.pop();
            for (int i = 0; i < matrix.length && !visitedCol[pos.y]; i++){
                matrix[i][pos.y] = 0;
            }

            visitedCol[pos.y] = true;

            for (int j = 0; j < matrix[0].length && !visitedRow[pos.x]; j++){
                matrix[pos.x][j] = 0;
            }

            visitedRow[pos.x] = true;
        }
    }

    public static void main(String[] args){
        SetMatrixZero smz = new SetMatrixZero();
        int[][] matrix = {{1,2,3,4},{5,0,5,2},{8,9,2,0},{5,7,2,1}};
        smz.setZeroes(matrix);
        System.out.println(matrix);
    }
}
