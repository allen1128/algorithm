package com.xl.algo.deepdive.linkedlist;

public class RevertSinglyLinkedList {
    public SinglyLinkedList revert(SinglyLinkedList node) {
        SinglyLinkedList prev = null;
        SinglyLinkedList next = null;

        while (node != null) {
            next = node.getNext();
            node.setNext(prev);
            prev = node;
            node = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        RevertSinglyLinkedList revertSinglyLinkedList = new RevertSinglyLinkedList();
        SinglyLinkedList root = new SinglyLinkedList(1);
        root = SinglyLinkedList.appendLast(2, root);
        root = SinglyLinkedList.appendLast(3, root);
        root = SinglyLinkedList.appendLast(4, root);
        root = SinglyLinkedList.appendLast(5, root);
        root = revertSinglyLinkedList.revert(root);
        System.out.println(root);
    }

}
