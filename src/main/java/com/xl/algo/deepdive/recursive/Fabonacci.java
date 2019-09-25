package com.xl.algo.deepdive.recursive;

public class Fabonacci {
    public int solve(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return solve(n - 1) + solve(n - 2);
    }

    public static void main(String[] args) {
        Fabonacci fb = new Fabonacci();
        System.out.println(fb.solve(5));
    }
}
