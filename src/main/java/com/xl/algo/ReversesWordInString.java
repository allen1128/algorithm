package com.xl.algo;

import java.util.Arrays;
import java.util.Collections;

public class ReversesWordInString {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        int leftIndex = -1;
        int rightIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (leftIndex == -1) {
                    leftIndex = i;
                } else if (i == s.length() - 1){
                    rightIndex = i;
                }
            } else {
                if (leftIndex >= 0) {
                    rightIndex = i;
                }
            }

            if (leftIndex >= 0 && leftIndex < rightIndex) {
                sb.insert(0, s.substring(leftIndex, rightIndex+1));
                sb.insert(0, ' ');
                leftIndex = -1;
                rightIndex = -1;
            }
        }

        return sb.toString().trim();
    }

    public String reverseWords2(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        ReversesWordInString rwis = new ReversesWordInString();
        System.out.println(rwis.reverseWords2("hello world! i am here" ));

    }
}
