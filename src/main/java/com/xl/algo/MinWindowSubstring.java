package com.xl.algo;

public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        int[] val = new int[128];
        for (int i = 0; i < t.length(); i++) {
            val[t.charAt(i)]++;
        }

        int left  = 0;
        int right = 0;
        int width = Integer.MAX_VALUE;
        int count = t.length();
        int head = 0;

        while (right < s.length()) {
            char c = s.charAt(right++);
            if (val[c] > 0) {
                count--;
            }
            val[c]--;

            while (count == 0) {
                if (right - left < width) {
                    width = right - left;
                    head = left;
                }

                char lc = s.charAt(left++);

                if (val[lc] == 0) {
                    count++;
                }
                val[lc]++;
            }
        }

        return width == Integer.MAX_VALUE ? "" : s.substring(head, head + width);
    }

    public static void main(String [] args) {
        MinWindowSubstring mws = new MinWindowSubstring();
        System.out.println(mws.minWindow("bbbbbcccc", "bc"));
    }
}
