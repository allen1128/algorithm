package com.xl.algo.deepdive.tree;

public class PathSum {
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

    public boolean find(Node root, int sum) {
        if (root == null) {
            return sum == 0;
        }
        return find(root.left, sum - root.val) || find(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        PathSum ps = new PathSum();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.print(ps.find(root, 6));
    }
}
