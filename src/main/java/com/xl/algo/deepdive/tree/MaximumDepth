package com.xl.algo.deepdive.tree;

public class MaximumDepth {
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

    public static int depth(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(7);

        int d = MaximumDepth.depth(root);

        System.out.print(d);
    }
}
