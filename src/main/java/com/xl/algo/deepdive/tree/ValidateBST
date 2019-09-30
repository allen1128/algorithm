package com.xl.algo.deepdive.tree;

public class ValidateBST {
    public static class Node {
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
    public boolean validate(Node root) {
        return helper(root, null, null);
    }

    private boolean helper(Node node, Node left, Node right) {
        boolean valid = true;
        if (node == null) {
            return valid;
        }        
        if ((left != null && node.val <= left.val) || (right != null && node.val >= right.val)) {
            return false;
        }
        return helper(node.left, left, node) && helper(node.right, node, right);
    }
    
    public static void main(String[] args) {
        ValidateBST validateBST = new ValidateBST();
        Node root = new Node(10);
        root.left = new Node(4);
        root.right = new Node(12);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(10);
        System.out.print(validateBST.validate(root));
    }
}
