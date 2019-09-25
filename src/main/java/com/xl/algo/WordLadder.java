package com.xl.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int[] test = new int[2];
        Arrays.fill(test, 0, 1, 1);
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int index = helper(0, beginWord, endWord, new HashSet<>(wordList));
        if (index == Integer.MAX_VALUE) {
            return 0;
        } else {
            return index;
        }
    }

    public int helper(int level, String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.equals(endWord)) {
            return level + 1;
        }


        int llevel = Integer.MAX_VALUE;
        if (wordList.size() == 0) {
            return llevel;
        }

        for (int i = 0; i < beginWord.length(); i++) {
            StringBuilder sb = new StringBuilder(beginWord);
            for (int j = 0; j < 26; j++) {
                char c = (char)('a' + j);
                if (c != beginWord.charAt(i)) {
                    sb.setCharAt(i, c);
                    if (wordList.contains(sb.toString())) {
                        wordList.remove(sb.toString());
                        llevel = Math.min(helper(level + 1, sb.toString(), endWord, wordList), llevel);
                        wordList.add(sb.toString());
                    }
                }
            }
        }
        return llevel;
    }
    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        System.out.println(wl.ladderLength("hit", "cog", Arrays.asList(new String[]{"hot","dog","lot","cog"})));
    }
}
