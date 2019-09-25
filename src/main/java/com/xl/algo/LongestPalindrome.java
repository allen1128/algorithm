package com.xl.algo;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            String answer1 = palindrome(s, i, i);
            if (answer1.length() > answer.length()) {
                answer = answer1;
            }
            String answer2 = palindrome(s, i - 1, i);
            if (answer2.length() > answer.length()){
                answer = answer2;
            }
        }

        return answer;
    }

    public String palindrome(String s, int i, int j) {
        for (; i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j); i--, j++) ;

        if (j - 1 - i > 0 && i + 1 >= 0 && j - 1 < s.length()) {
            return s.substring(i + 1, j);
        }

        return "";
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome("bacab"));
    }
}
