package com.xl.algo.deepdive.tree;

public class BST {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }

        Node node = root;
        while (node != null) {
            if (node.data > data) {
                if (node.left == null) {
                    node.left = new Node(data);
                    return;
                }
                node = node.left;
            } else if (node.data < data) {
                if (node.right == null) {
                    node.right = new Node(data);
                    return;
                }
                node = node.right;
            } else {
                break;
            }
        }
    }

    public void delete(int data) {
        Node node = root;
        Node pnode = null;

        //find node
        while (node != null && node.data != data) {
            pnode = node;
            if (node.data > data) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if (node == null) {
            return;
        }

        //if both left and right child are not null, find the right's most left, and update the node.data with it.
        if (node.left != null && node.right != null) {
            Node minNode = node.right;
            Node minPNode = node;

            while (minNode.left != null) {
                minPNode = minNode;
                minNode = minNode.left;
            }

            node.data = minNode.data;
            node = minNode;
            pnode = minPNode;
        }

        //find its child
        Node child = null;
        if (node.left != null) {
            child = node.left;
        } else if (node.right != null) {
            child = node.right;
        }

        //remove the node by pointing its parent's child to node's child
        if (pnode == null) {
            root = child;
        } else if (pnode.left == node) {
            pnode.left = child;
        } else {
            pnode.right = child;
        }
    }

    public boolean find(int data) {
        Node node = root;

        while (node != null && node.data != data) {
            if (node.data > data) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return node != null && node.data == data;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(1);
        bst.insert(5);
        bst.insert(8);
        System.out.println(bst.find(5));
        bst.delete(5);
        System.out.println(bst.find(5));

        bst.insert(55);

        System.out.println(bst.find(55));
    }

}
