package com.xl.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
//    public boolean wordBreak(String s, List<String> wordDict) {
//        boolean words[] = new boolean[s.length()+1];
//
//        for (int i = 0; i < words.length; i++) {
//            words[i] = false;
//        }
//
//        words[0]=true;
//
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j < i; j++) {
//                if (words[j] && wordDict.contains(s.substring(j, i+1))) {
//                    words[i+1] = true;
//                }
//            }
//        }
//
//        return words[s.length()];
//    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        wb.wordBreak("leetcode", Arrays.asList(new String[] {"leet", "code"}));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }

        for (int j = 0; j < s.length(); j++) {
            String str = s.substring(0, j + 1);
            if (wordDict.contains(str)) {
                if (wordBreak(s.substring(j + 1, s.length()), wordDict)) {
                    return true;
                }
            }
        }

        return false;
    }
}
