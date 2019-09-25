package com.xl.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        helper(beginWord, endWord, new HashSet<>(wordList));
        return result;
    }


    public void helper(String beginWord, String endWord, Set<String> wordList){
        Queue<String> queue = new LinkedList<>();
        Queue<List<String>> pathq = new LinkedList<>();
        List<String> path = new ArrayList<>();

        if (!wordList.contains(endWord)) {
            return;
        }

        queue.offer(beginWord);
        path.add(beginWord);
        pathq.offer(path);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String candidate = queue.poll();
                wordList.remove(candidate);
                List<String> pathC = pathq.poll();

                if (candidate.equals(endWord)) {
                    result.add(new ArrayList<>(pathC));

                }

                if (result.size() == 0) { //nothing find, prepare the next round
                    for (int j = 0; j < candidate.length(); j++) {
                        StringBuilder sb = new StringBuilder(candidate);
                        for (char c = 'a'; c <= 'z'; c++) {
                            sb.setCharAt(j, c);
                            String newWord = sb.toString();
                            if (!wordList.contains(newWord)) {
                                continue;
                            }

                            List<String> pathN = new ArrayList<>(pathC);
                            pathN.add(newWord);
                            queue.offer(newWord);
                            pathq.offer(pathN);
                        }
                    }
                }
            }

            if (result.size() > 0) return;
        }
    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> tree = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        bfs(tree, distance, beginWord, endWord, new HashSet<>(wordList));
        dfs(tree, distance, endWord, beginWord, new ArrayList<>());
        return result;
    }

    public void bfs(Map<String, Set<String>> tree, Map<String, Integer> distance, String beginWord, String endWord, Set<String> wordList) {
        if (!wordList.contains(endWord)) {
            return;
        }

        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String candidate = queue.poll();

                wordList.remove(candidate);

                for (int i = 0; i < candidate.length(); i++) {
                    StringBuilder sb = new StringBuilder(candidate);
                    for (char j = 'a'; j <= 'z'; j++) {
                        sb.setCharAt(i, j);
                        String newWord = sb.toString();
                        if (wordList.contains(newWord)) {
                            Set<String> set = tree.getOrDefault(newWord, new HashSet<>());
                            set.add(candidate);
                            tree.put(newWord, set);

                            if (!distance.containsKey(newWord)) {
                                queue.offer(newWord);
                                distance.put(newWord, distance.get(candidate) + 1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void dfs(Map<String, Set<String>> tree, Map<String, Integer> distance, String beginWord, String endWord, List<String> path) {
        path.add(beginWord);

        if (beginWord.equals(endWord)) {
            List<String> res = new ArrayList<>(path);
            Collections.reverse(res);
            result.add(res);
        } else {
            Set<String> leaf = tree.get(beginWord);
            if (leaf != null) {
                for (String l : leaf) {
                    if (distance.get(beginWord) == distance.get(l) + 1) {
                        dfs(tree, distance, l, endWord, path);
                    }
                }
            }
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        WordLadder2 wl2 = new WordLadder2();
        System.out.println(wl2.findLadders("hit", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));
    }
}
