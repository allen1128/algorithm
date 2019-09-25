package com.xl.algo;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num.length() - k <= 0) {
            return "0";
        } else if (k == 0) {
            return num;
        }

        StringBuilder sb = new StringBuilder(num);
        int index = 0;
        while (k > 0 && index < sb.length() - 1) {
            if (sb.charAt(index) > sb.charAt(index+1)) {
                sb.deleteCharAt(index);
                k--;
                index--;
            } else {
                index++;
            }
        }

        String result = sb.toString();
        if (k > 0) {
            result = sb.substring(0, sb.length() - k);
        }

        index = 0;
        while (index < result.length() && result.charAt(index) == '0') {
            index++;
        }
        result = result.substring(index, result.length());

        return (result.length() == 0) ? "0" : result;
    }

    public static void main(String[] args) {
        RemoveKDigits rd = new RemoveKDigits();
        System.out.println(rd.removeKdigits("10", 1));
    }
}
