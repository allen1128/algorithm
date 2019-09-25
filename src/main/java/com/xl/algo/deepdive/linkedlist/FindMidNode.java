package com.xl.algo.deepdive.linkedlist;

public class FindMidNode {
    public SinglyLinkedList findMid(SinglyLinkedList root) {
        SinglyLinkedList slow = root;
        SinglyLinkedList fast = root;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        FindMidNode fmn = new FindMidNode();
        SinglyLinkedList node = new SinglyLinkedList(1);
        SinglyLinkedList root = node;
        node.next = new SinglyLinkedList(1);
        node = node.next;
        node.next = new SinglyLinkedList(2);
        node = node.next;
        node.next = new SinglyLinkedList(3);
        node = node.next;
        node.next = new SinglyLinkedList(4);
        node = node.next;
        node.next = new SinglyLinkedList(5);
        node = node.next;
        node.next = new SinglyLinkedList(6);
        node = node.next;
        node.next = new SinglyLinkedList(7);
        node = node.next;
        node.next = new SinglyLinkedList(8);
        node = node.next;
        node.next = new SinglyLinkedList(9);
        node = node.next;
        node.next = new SinglyLinkedList(10);
        node = node.next;
        node.next = new SinglyLinkedList(11);

        System.out.println(fmn.findMid(root));
    }
}
