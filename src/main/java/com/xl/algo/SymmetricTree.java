package com.xl.algo;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree {

    public int index = 0;
    public boolean r = true;
    List<TreeNode> list = new ArrayList<>();

    public boolean isSymmetric(TreeNode root) {
        postorder(root);
        index = list.size() - 1;
        preorder(root);
        return r;
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            if (list.get(index) != null) {
                r = false;
            }
            return;
        }

        if (list.get(index) == null || root.val != list.get(index).val) {
            r = false;
            return;
        }

        index--;

        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(TreeNode root) {
        if (root == null) {
            list.add(null);
            return;
        }
        postorder(root.left);
        postorder(root.right);
        list.add(root);
    }

    //breath traversal
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> tempList = new ArrayList<>();

            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                tempList.add(node);
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }

            if (!isSumme(tempList)){
                return false;
            }
        }
        return true;
    }

    public boolean isSumme(List<TreeNode> list) {
        for (int i = 0, j = list.size() - 1; i < list.size() / 2; i++, j--) {
            TreeNode l = list.get(i);
            TreeNode r = list.get(j);
            if (l == null && r == null) continue;;
            if (l == null || r == null) return false;
            if (l.val != r.val) return false;
        }
        return true;
    }
}

