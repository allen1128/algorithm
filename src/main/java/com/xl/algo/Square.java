package com.xl.algo;

public class Square {
    public double mySqrt(double v) {
        //watch point: add the check for edge cases.
        if (v == 1.0) {
            return 1;
        }
        if (v < 0) {
            throw  new IllegalArgumentException();
        }

        if (v == 0) {
            return 0;
        }

        if (v < 1) {
            return helper(v, 1, v);
        } else {
            return helper(1, v, v);
        }
    }

    private double helper(double lower, double upper, double target) {
        double precision = 0.000001;
        double value = lower/ 2 + upper/ 2;
        double temp = value * value;

        //watch point: math.abs
        if (Math.abs(temp - target) < precision) {
            return value;
        } else if (temp > target){
            return helper(lower, value, target);
        } else {
            return helper(value, upper, target);
        }
    }

    public static void main(String[] args){
        Square square = new Square();

        while (true) {
            System.out.println(square.mySqrt(4));
        }
    }
}
