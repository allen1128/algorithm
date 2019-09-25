package com.xl.algo;

public class PushDominoes {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder(dominoes);
        int left = 0;
        int right = 0;
        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == 'L' || dominoes.charAt(i) == 'R') {
                right = i;
                expend(sb, left, right);
                left = right;
            }
        }

        return sb.toString();
    }

    public void expend(StringBuilder dominoes, int left, int right) {
        char c_left = dominoes.charAt(left);
        char c_right = dominoes.charAt(right);

        if (c_left == 'L' && c_right == 'R') {
            return;
        }
        else if (c_left == 'R' && c_right == 'L') {
            while (left + 1 < right - 1) {
                dominoes.setCharAt(++left, 'R');
                dominoes.setCharAt(--right, 'L');
            }
        }
        else if (c_left == 'R') {
            while (left < right) {
                dominoes.setCharAt(++left, 'R');
            }
        }
        else if (c_right == 'L') {
            while (left < right) {
                dominoes.setCharAt(--right, 'L');
            }
        }
    }

    public static void main(String[] args) {
        PushDominoes pd = new PushDominoes();
        System.out.println(pd.pushDominoes(".L.R...LR..L.."));
    }
}
