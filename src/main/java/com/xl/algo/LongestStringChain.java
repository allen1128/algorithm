package com.xl.algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestStringChain {
    Map<String, Integer> memo = new HashMap<>();

    public int longestStrChain(String[] words) {
        if (words.length <= 1) {
            return words.length;
        }
        int max = 0;
        List<String> wordList = Arrays.stream(words).sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        for (String word : wordList) {
            memo.put(word, 1);
            for (int j = 0; j < word.length(); j++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(j);
                if (memo.containsKey(sb.toString()) && memo.get(sb.toString()) + 1 > memo.get(word)) {
                    memo.put(word, memo.get(sb.toString()) + 1);
                }
            }
            max = Math.max(max, memo.get(word));
        }
        return max;
    }

    public int longestStrChain2(String[] words) {
        count = 0;
        if (words.length <= 1) {
            return words.length;
        }

        int max = 0;
        List<String> wordList = Arrays.stream(words).sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        for (int i = 0; i < wordList.size(); i++) {
            max = Math.max(max, helper(wordList, wordList.get(i), i + 1));
        }
        return max;
    }

    public int helper(List<String> wordList, String target, int index) {
        if (wordList.size() == 0) {
            return 0;
        }
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        int max = 0;
        for (int i = index; i < wordList.size(); i++) {
            if (contains(wordList.get(i), target)) {
                int lmax = helper(wordList, wordList.get(i), i + 1);
                memo.put(wordList.get(i), lmax);
                max = Math.max(max, lmax);

            }
        }
        max++;
        memo.put(target, max);
        return max;
    }

    int count = 0;
    public boolean contains(String a, String b) {
         for (int i = 0; i < a.length(); i++) {
             StringBuilder sb = new StringBuilder(a);
             sb.deleteCharAt(i);
             if (sb.toString().equals(b)) {
                 return true;
             }
        }
        return false;
    }

    public static void main(String[] args) {
        LongestStringChain lsc = new LongestStringChain();
        System.out.println(lsc.contains("bca","bda"));
        System.out.println(lsc.longestStrChain(new String[] {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"}));
        System.out.println(lsc.longestStrChain2(new String[] {"a","b","ba","bca","bda","bdca"}));
    }
}

