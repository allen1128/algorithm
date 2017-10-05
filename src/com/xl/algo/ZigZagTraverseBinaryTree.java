package com.xl.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraverseBinaryTree {

    static public class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        boolean direction = true;
        int start = 0;

        while (true){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }

                if (direction){
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }

                queue.offer(node.left);
                queue.offer(node.right);
            }

            direction = !direction;
            if (list.size() > 0){
                result.add(list);
            } else {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args){
        ZigZagTraverseBinaryTree zztbt = new ZigZagTraverseBinaryTree();
        TreeNode root = new ZigZagTraverseBinaryTree.TreeNode(1);
        root.left = new ZigZagTraverseBinaryTree.TreeNode(2);
        root.right = new ZigZagTraverseBinaryTree.TreeNode(3);
        root.right.left = new ZigZagTraverseBinaryTree.TreeNode(6);
        root.right.right = new ZigZagTraverseBinaryTree.TreeNode(7);

        System.out.println(zztbt.zigzagLevelOrder(root));
    }
}
