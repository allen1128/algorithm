package com.xl.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {
    public Map<String, List<String>> cache = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();

        if (s.length() == 0) {
            result.add(s);
        } else if (cache.get(s) != null) {
            return cache.get(s);
        }


        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> fragments =
                        wordBreak(s.substring(word.length()), wordDict);

                for (String fragment : fragments) {
                    if (fragment.length() > 0) {
                        result.add(word + " " + fragment);
                    } else {
                        result.add(word);
                    }
                }

            }
        }


        cache.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        WordBreakII wb2 = new WordBreakII();
        System.out.println(wb2.wordBreak("sandstoe", Arrays.asList(new String[]{"sands", "toe"})));

    }
}
