package com.xl.algo.deepdive.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelTraversal {
    List<Integer> level(BST.Node node) {
        List<Integer> result = new ArrayList<>();
        Queue<BST.Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BST.Node n = queue.poll();
                result.add(n.data);
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LevelTraversal lt = new LevelTraversal();
        BST.Node node = new BST.Node(2);
        node.left = new BST.Node(1);
        node.right = new BST.Node(4);
        node.right.left = new BST.Node(3);
        node.right.left.left = new BST.Node(3);
        node.right.right = new BST.Node(5);
        System.out.println(lt.level(node));
    }
}
