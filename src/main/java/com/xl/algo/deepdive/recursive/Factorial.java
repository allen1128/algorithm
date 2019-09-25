package com.xl.algo.deepdive.recursive;

public class Factorial {
    public long solve(int n) {
        if (n == 1) {
            return n;
        }
        return n * solve(n - 1);
    }
    public static void main(String[] args) {
        Factorial ft = new Factorial();
        System.out.println(ft.solve(5));
    }
}
