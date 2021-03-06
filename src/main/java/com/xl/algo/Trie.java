package com.xl.algo;

import java.util.*;

public class Trie {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean hasWord = false;
        public TrieNode(){}
    }

    TrieNode root = new TrieNode();

    public Trie(){
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word.length() == 0){
            return;
        }

        TrieNode node = root;
        char c = ' ';

        for (int i = 0; i < word.length(); i++){
            c = word.charAt(i);
            int index = c - 'a';
            if (node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }

        node.hasWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null){
                return false;
            } else {
                node = node.children[c - 'a'];
            }
        }

        return node.hasWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if (node.children[c - 'a'] == null){
                return false;
            } else {
                node = node.children[c - 'a'];
            }
        }

        return node != null;
    }

    public List<String> findStartsWith(String prefix){
        List<String> result = new ArrayList<String>();
        TrieNode node = root;
        StringBuilder sb = new StringBuilder(prefix);

        for (int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if (node.children[c - 'a'] == null){
                return result;
            } else {
                node = node.children[c - 'a'];
            }
        }

        helper(node, prefix, result);
        return result;
    }

    public void helper(TrieNode node, String prefix, List<String> result){
        if (node.hasWord){
            result.add(prefix);
        }

        TrieNode nsss = null;
        for (int i = 0; i < node.children.length; i++){
            TrieNode n = node.children[i];
            if (n != null) {
                helper(n, prefix + (char)(i + 'a'), result);
            }
        }
    }


    static public void main(String args[]){
        Trie trie = new Trie();

        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        trie.insert("apps");
        System.out.println(trie.search("app"));
        System.out.println(trie.search("ad"));
        System.out.println(trie.search("applepie"));
        System.out.println(trie.search("rest"));
        System.out.println(trie.search("jan"));
        System.out.println(trie.search("rent"));
        System.out.println(trie.search("beer"));
        System.out.println(trie.search("jam"));
        System.out.println(trie.search("apps"));
        System.out.println(trie.findStartsWith("jan"));

    }
}
