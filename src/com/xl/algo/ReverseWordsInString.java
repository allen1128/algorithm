package com.xl.algo;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsInString {
    //points to take away:
    //regular expression for one or more space
    //reverse only works with list and objects implementing comparable interface
    //Collections class and String class.
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        ReverseWordsInString rw = new ReverseWordsInString();
        System.out.println(rw.reverseWords(" abc efg ijk"));
    }
}
