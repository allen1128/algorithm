package com.xl.algo.trie;

import java.util.Arrays;
import java.util.Stack;

public class Trie {
    public static class Node {
        Node[] children = new Node[26];
        boolean hasWord = false;

        public boolean remove(Node child) {
            for (int i = 0; i < children.length; i++) {
                if (children[i] == child) {
                    children[i] = null;
                    return true;
                }
            }
            return false;
        }

        public boolean isEmpty() {
            return !Arrays.stream(children)
                .filter( n -> n != null)
                .findAny()
                .isPresent();
        }
    }

    private Node root = new Node();

    public void insert(String word) {
        if (isEmpty(word)) {
            return;
        }

        Node node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Node();
            }
            node = node.children[index];
        }
        node.hasWord = true;
    }

    public boolean find(String word) {
        Node node = getNode(word);
        return node != null && node.hasWord;
    }

    public void remove(String word) {
        if (isEmpty(word)) {
            return;
        }

        Node node = root;
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return;
            }
            stack.add(node);
            node = node.children[index];
        }

        node.hasWord = false;

        if (!node.isEmpty()) {
            return;
        } else {
            while (!stack.isEmpty()) {
                Node parent = stack.pop();
                parent.remove(node);
                if (!parent.isEmpty()) {
                    break;
                }
                node = parent;
            }
        }
    }

    public boolean isPrefix(String prefix) {
        return getNode(prefix) != null;
    }

    private Node getNode(String word) {
        if (isEmpty(word)) {
            return null;
        }

        Node node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    private boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("insomnia");
        trie.remove("insomnia");
        System.out.println(trie.find("insomnia"));
        trie.insert("insomnia");
        System.out.println(trie.find("insomnia"));
        trie.remove("insomnia");
        System.out.println(trie.find("insomnia"));
        trie.insert("insomniaa");
        System.out.println(trie.find("insomnia"));
        System.out.println(trie.isPrefix("insomn"));
        trie.remove("insomniaa");
        System.out.println(trie.isPrefix("insomn"));
    }
}
