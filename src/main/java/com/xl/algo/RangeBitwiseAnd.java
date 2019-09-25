package com.xl.algo;

public class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int m, int n) {
        int r = m;
        for (int i = m + 1 ; i <= n && r != 0; i++) {
            r &= i;
            if (i == Integer.MAX_VALUE) {
                return r;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        RangeBitwiseAnd rba = new RangeBitwiseAnd();
        System.out.println(rba.rangeBitwiseAnd(2147483646, 2147483647));
    }
}
