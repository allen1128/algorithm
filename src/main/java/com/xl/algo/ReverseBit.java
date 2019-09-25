package com.xl.algo;

public class ReverseBit {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) { //loop 32 times because integer is 32 bit
            int end = n & 1; //get the last bit
            n >>= 1; //right shift therefore the last bit is removed (same as dividied by 2)
            result <<= 1; //left shift therefore add one more bit (multiple by 2)
            result |= end; //set the last bit of result same as the last bit
        }
        return result;
    }

    public int reverseBits2(int n) {
        int result = 0;
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
        for (int i = 31; i >= 0; i--) {
            int bit = sb.charAt(i) - '0';
            result <<= 1;
            result |= bit;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBit rb = new ReverseBit();
        System.out.println(Integer.toBinaryString(2147483646));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.parseInt("-1", 10));
        //System.out.println(Integer.parseInt("11111111111111111111111111111111", 2)); //parseInt won't work with negative binary representation
        System.out.println(rb.reverseBits2(-3));
        System.out.println(rb.reverseBits(-3));
    }

}
