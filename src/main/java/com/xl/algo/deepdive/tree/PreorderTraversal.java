package com.xl.algo.deepdive.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.xl.algo.deepdive.tree.BST.Node;

public class PreorderTraversal {
    public List<Integer> preorder(BST.Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.data);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PreorderTraversal it = new PreorderTraversal();
        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(4);
        node.right.left = new Node(3);
        node.right.right = new Node(5);
        System.out.println(it.preorder(node));
    }

}
