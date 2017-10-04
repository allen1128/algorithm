package com.xl.algo;

public class LowestCommonAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = helper(root, p, q);
        return node;
    }

    public TreeNode helper(TreeNode node, TreeNode p, TreeNode q){
        //when node is equal to p or q, no need to go further because it won't be a lower common ancestor.
        if (node == p || node == q || node == null){
            return node;
        }
        
        TreeNode left = helper(node.left, p, q);
        TreeNode right = helper(node.right, p, q);

        if (left != null && right != null){
            return node;
        }

        if (left != null){
            return left;
        }

        if (right != null){
            return right;
        }
        return null;
    }
}
