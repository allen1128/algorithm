package com.xl.algo;

public class MaxPathSum {

    /*
     * Definition for a binary tree node.
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int max = Integer.MIN_VALUE;;

    public int helper(TreeNode root, int sum) {
        if (root == null) return 0;
        int lsum = root.val + helper(root.left, 0) + helper(root.right, 0);
        max = Math.max(lsum, max);
        return lsum + sum;
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0);
        return max;
    }

    public static void main(String[] args) {
        MaxPathSum mps = new MaxPathSum();
//        TreeNode node = new TreeNode(-10);
//        node.left = new TreeNode(9);
//        node.right = new TreeNode(20);
//        node.right.left = new TreeNode(15);
//        node.right.right = new TreeNode(7);
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        //-10,9,20,null,null,15,7
        System.out.println(mps.maxPathSum(node));
    }
}
