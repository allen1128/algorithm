package com.xl.algo;

public class IntegerDivide {
    public int divide(int dividend, int divisor) {
        boolean negate = false;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend == divisor) {
            return 1;
        }

        //turn both number to negative because Integer.MIN cannot be converted to positive
        //but Integer.MAX can be converted to negative
        if (dividend > 0) {
            dividend = -dividend;
            negate = !negate;
        }

        if (divisor > 0) {
            divisor = -divisor;
            negate = !negate;
        }

        if (divisor < dividend) {
            return 0;
        }

        int result = 0;
        while (dividend <= divisor) {
            int number = 1;
            int sum = divisor;

            //know that divident and sum here are both negative, so only continues when there are more to abstract
            while (dividend - sum <= sum) {
                number += number;
                sum += sum;
            }
            result += number;
            dividend -= sum;
        }

        return negate ? -result : result;
    }


    public static void main(String [] args){
        IntegerDivide integerDivide = new IntegerDivide();
        System.out.println(integerDivide.divide(9,2));
        System.out.println(integerDivide.divide(Integer.MIN_VALUE, 1));
    }
}

