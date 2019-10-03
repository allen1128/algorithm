package com.xl.algo.deepdive.tree;

public class FlipBinaryTree {
    public static class Node {
        public Node left;
        public Node right;
        public int val;

        public Node(int val) {
            this.val = val;
        }

        @Override public String toString() {
            return "Node{" + "left=" + left + ", right=" + right + ", val=" + val + '}';
        }
    }

    public static void flip(Node root) {
        if (root == null) {
            return;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        flip(root.left);
        flip(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        FlipBinaryTree.flip(root);
        System.out.print(root);
    }
}
