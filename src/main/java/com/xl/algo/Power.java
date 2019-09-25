package com.xl.algo;

public class Power {
    public double solve(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double ans = solve(x, n / 2);

        if (n % 2 == 0) {
            return ans * ans;
        }

        if (n >= 1) {
            return ans * ans * x;
        }

        return ans * ans / x;

    }

    public static void main(String[] args) {
        Power p = new Power();
        System.out.println(p.solve(2.0, -2147483648));
    }
}
