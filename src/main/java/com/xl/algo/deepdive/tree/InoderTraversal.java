package com.xl.algo.deepdive.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.xl.algo.deepdive.tree.BST.Node;


public class InoderTraversal {
    public List<Integer> inorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node node = root;

        while (node != null || !stack.isEmpty()) {
            //only true for root and all the right trees.
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            result.add(node.data);
            node = node.right;
        }

        return result;
    }

    public List<Integer> inorder2(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        helper(root.left, result);
        result.add(root.data);
        helper(root.right, result);
    }

    public static void main(String[] args) {
        InoderTraversal it = new InoderTraversal();
        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(4);
        node.right.left = new Node(3);
        node.right.right = new Node(5);
        System.out.println(it.inorder(node));
    }
}
