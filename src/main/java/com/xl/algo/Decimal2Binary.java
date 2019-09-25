package com.xl.algo;

import java.util.Random;

public class Decimal2Binary {
    public String base2(int i) {
        StringBuilder sb = new StringBuilder();
        while (i > 0) {
            sb.append(i % 2);
            i = i / 2;
        }

        return sb.reverse()
                .toString();
    }

    public String baseNeg2_1(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n & 1);
            if ((n & 1) != 0) n--;
            n = n / -2;
        }
        return sb.length() == 0
                ? "0"
                : sb.reverse()
                        .toString();
    }

    public String baseNeg2(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n & 1);
            System.out.println(n);
            n = -(n >> 1);
        }

        Math.random();
        Random random = new Random();
        random.nextDouble();
        return sb.length() == 0
                ? "0"
                : sb.reverse()
                        .toString();
    }

    public static void main(String[] args) {
        Decimal2Binary d2b = new Decimal2Binary();
        System.out.println( -7 >> 1);
        System.out.println( 7 >> 1);
        //System.out.println(d2b.baseNeg2(-9));
    }
}
