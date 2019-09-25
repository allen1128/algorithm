package com.xl.algo;

public class LinkedListRevert {
    public static class Node {
        private int val;
        private Node next;

        public Node(int v) {
            this.val = v;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }


    public Node revert(Node n) {
        if (n == null || n.next == null) {
            return n;
        }

        Node prev = null;
        while (n != null) {
            Node temp = n.next;
            n.next = prev;
            prev = n;
            n = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        LinkedListRevert llr = new LinkedListRevert();
        Node n = new Node(0);
        n.next = new Node(1);
        n.next.next = new Node(2);
        n.next.next.next = new Node(3);
        System.out.println(llr.revert(n));
    }
}
