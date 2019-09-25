package com.xl.algo;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafSum {
//    List<List<TreeNode>> paths = new ArrayList<>();
//    public int sumNumbers(TreeNode root) {
//        helper(root, new ArrayList<>());
//        int sum = 0;
//        for (List<TreeNode> path : paths) {
//            int localSum = 0;
//            for (TreeNode n : path) {
//                localSum = n.val + (localSum * 10);
//            }
//            sum += localSum;
//        }
//        return sum;
//    }
//
//    public void helper(TreeNode root, List<TreeNode> path) {
//        if (root.left == null && root.right == null) {
//            path.add(root);
//            paths.add(new ArrayList<>(path));
//            return;
//        }
//        path.add(root);
//        if (root.left != null) {
//            helper(root.left, path);
//            path.remove(path.size() - 1);
//        }
//
//        if (root.right != null) {
//            helper(root.right, path);
//        }
//    }

    public int total = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return total;
    }

    public void helper(TreeNode root, int sum) {
        if (root == null) {
            total += sum;
            return;
        }

        sum = root.val + sum * 10;

        if (root.left == null && root.right == null) {
            total += sum;
        }

        if (root.left != null) {
            helper(root.left, sum);
        }

        if (root.right != null) {
            helper(root.right, sum);
        }
    }



    public static void main(String[] args) {
        RootToLeafSum cbs = new RootToLeafSum();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        System.out.println(cbs.sumNumbers(node));

    }
}
