package com.xl.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidHelper(root, null, null);
    }

    public boolean isValidHelper(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        return (min == null || node.val > min)
                && (max == null || node.val < max)
                && isValidHelper(node.left, min, node.val)
                && isValidHelper(node.right, node.val, max);
    }

    //flattern and compare the list
     public boolean isValidBST2(TreeNode root) {
         List<TreeNode> list = new ArrayList<>();
         traverse(root, list);

         TreeNode prev = null;
         for (TreeNode node : list) {
             if (prev != null) {
                 if (node.val <= prev.val) {
                     return false;
                 }
             }
             prev = node;
         }
         return true;
     }


    //stack
     public void traverse(TreeNode node, List<TreeNode> list) {
         if (node == null) {
             return;
         }

         traverse(node.left, list);
         list.add(node);
         traverse(node.right, list);
     }

     public boolean isValidBST3(TreeNode node) {
         Stack<TreeNode> stack = new Stack<>();
         TreeNode pre = null;

         while (node != null || !stack.isEmpty()) {
             while (node != null) {
                 stack.push(node);
                 node = node.left;
             }

             node = stack.pop();
             if (pre != null && node.val <= pre.val) {
                 return false;
             }

             pre = node;
             node = node.right;
         }

         return true;
     }


    //recursive without min and max
     private TreeNode prev;
     public boolean isValidBST4(TreeNode node) {
         if (node == null) return true;
         if (node.left != null) {
             if (!isValidBST4(node.left)) {
                 return false;
             }
         }

         if (prev != null && node.val <= prev.val){
             return false;
         }

         prev = node;

         if (!isValidBST4(node.right)) {
             return false;
         }

         return true;
     }
}
