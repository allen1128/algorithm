package com.xl.algo;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointer {

    // Definition for binary tree with next pointer.
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode temp = null;
            for (int i = 0; i < size; i++) {
                TreeLinkNode node = queue.poll();
                if (i == 0) {
                    temp = node;
                } else {
                    node.next = temp;
                    temp = node;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
    }

}
