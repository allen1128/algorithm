package com.xl.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderSuccessor {
    public class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        boolean next = false;

        while (!stack.isEmpty() || node != null){
            if (node != null){
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();

                if (node == p){
                    next = true;
                } else if (next){
                    return node;
                }

                node = node.right;
            }
        }

        return node;
    }

}
