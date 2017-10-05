package com.xl.algo;

public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length ==0){
            return;
        }

        int start = 0;
        int end = matrix.length - 1;

        while (start < end){
            int count = 0;
            for (int i = start; i < end; i++, count++){
                int temp = matrix[i][end];
                matrix[i][end] = matrix[start][i];
                matrix[start][i] = matrix[end-count][start];
                matrix[end-count][start] = matrix[end][end-count];
                matrix[end][end-count] = temp;
            }

            start++;
            end--;
        }
    }
}
