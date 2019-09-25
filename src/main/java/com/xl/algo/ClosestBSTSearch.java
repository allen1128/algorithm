package com.xl.algo;

import java.util.ArrayList;
import java.util.List;

public class ClosestBSTSearch {
    public int closestValue2(TreeNode root, double target) {
        List<TreeNode> list = new ArrayList<>();
        traverse(root, list);
        return list.get(findIndex(list, target)).val;
    }

    public void traverse(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        traverse(root.left, list);
        list.add(root);
        traverse(root.right, list);
    }

    public int findIndex(List<TreeNode> list, double target) {
        int left = 0;
        int right = list.size() - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).val == target) {
                return mid;
            } else if (list.get(mid).val > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (Math.abs((double)list.get(left).val - target) < Math.abs((double)list.get(right).val - target)){
            return left;
        } else {
            return right;
        }
    }

    //D & C solution
    public int closestValue(TreeNode root, double target) {
        TreeNode temp = root;
        while (root != null) {
            if (root.val == target){
                return root.val;
            } else {
                if (Math.abs(root.val - target) < Math.abs(temp.val - target)) {
                    temp = root;
                }

                if (root.val < target) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
        }
        return temp.val;
    }

    public static void main(String[] args){
        ClosestBSTSearch cbs = new ClosestBSTSearch();
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.left.left.left = new TreeNode(1);

        System.out.println(cbs.closestValue(node, 2.8517234));
    }
}
