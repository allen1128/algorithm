package com.xl.algo;

public class NumberToWord {

    public String numberToWords(int num) {
        return helper(num).trim();
    }

    public String helper(int num) {
        StringBuilder sb = new StringBuilder();

        if (num <= 20) {
            sb.append(letter(num));
        } else if (num < 100) {
            sb.append(letter(num / 10 * 10) + letter(num % 10));
        } else if (num < 1000) {
            sb.append(helper(num / 100) + "Hundred " + helper(num % 100));
        } else if (num < 1000000) {
            sb.append(helper(num / 1000) + "Thousand " + helper(num % 1000));
        } else if (num < 1000000000) {
            sb.append(helper(num / 1000000) + "Million " + helper(num % 1000000));
        } else {
            sb.append(helper(num / 1000000000) + "Billion " + helper(num % 1000000000));
        }

        return sb.toString();
    }

    public String letter(int num) {
        if (num == 1) {
            return "One ";
        } else if (num == 2) {
            return "Two ";
        } else if (num == 3) {
            return "Three ";
        } else if (num == 4) {
            return "Four ";
        } else if (num == 5) {
            return "Five ";
        } else if (num == 6) {
            return "Six ";
        } else if (num == 7) {
            return "Seven ";
        } else if (num == 8) {
            return "Eight ";
        } else if (num == 9) {
            return "Nine ";
        } else if (num == 10) {
            return "Ten ";
        } else if (num == 11) {
            return "Elevent ";
        } else if (num == 12) {
            return "Twleve ";
        } else if (num == 13) {
            return "Thirteen ";
        } else if (num == 14) {
            return "Fourteen ";
        } else if (num == 15) {
            return "Fifteen ";
        } else if (num == 16) {
            return "Sixteen ";
        } else if (num == 17) {
            return "Seventeen ";
        } else if (num == 18) {
            return "Eighteen ";
        } else if (num == 19) {
            return "Ninteen ";
        } else if (num == 20) {
            return "Twenty ";
        } else if (num == 30) {
            return "Thirty ";
        } else if (num == 40) {
            return "Fourty ";
        } else if (num == 50) {
            return "Fifty ";
        } else if (num == 60) {
            return "Sixty ";
        } else if (num == 70) {
            return "Seventy ";
        } else if (num == 80) {
            return "Eighty ";
        } else if (num == 90) {
            return "Ninty ";
        }

        return "";
    }

    public static void main(String[] args) {
        NumberToWord nw = new NumberToWord();
        System.out.println(nw.numberToWords(100034));
    }
}
