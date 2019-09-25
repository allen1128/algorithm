package com.xl.algo;

public class SquareRoot {
    public int solution(int A, int B){
        int result = 0;
        if (B <= 0){
            return result;
        }

        int rightSqr = (int)Math.floor(Math.sqrt(B));

        if (A > 0) {
            int leftSqr = (int) Math.floor(Math.sqrt(A));

            if (Math.pow(leftSqr, 2) == A) {
                result = rightSqr - leftSqr + 1;
            } else {
                result = rightSqr - leftSqr;
            }
        } else {
            result = rightSqr;
        }

        return result;
    }

    public static void main(String[] args){
        SquareRoot sr = new SquareRoot();
        System.out.println(sr.solution(9, 9));
    }
}
