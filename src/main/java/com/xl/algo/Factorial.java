package com.xl.algo;

public class Factorial {
    public int solution(int N, int K) {
        if (K > N || K < 0 || N < 0){
            return -1;
        }

        if (N == 0){
            return 1;
        }

        double result = 1.0;

        int M = N - K;
        while (result < 1000000000 && N >= 1 && N > K){
            result *= N;

            if (M >= 1){
                result /= M;
            }

            N--;
            M--;
        }

        if (result >= 1000000000){
            return -1;
        }

        while (M >= 1){
            result /= M;
            M--;
        }

        return (int)result;
    }

    public static void main(String[] args){
        Factorial f = new Factorial();
        System.out.println(f.solution(40, 30));
    }
}
