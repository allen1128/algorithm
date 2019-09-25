package com.xl.algo.deepdive.linkedlist;

public class MergeTwoLinkedList {
    public SinglyLinkedList merge(SinglyLinkedList one, SinglyLinkedList another) {
        SinglyLinkedList dummyhead = new SinglyLinkedList(-1);
        SinglyLinkedList node = dummyhead;
        SinglyLinkedList temp = null;
        while (one != null && another != null) {
            if (one.data <= another.data) {
                temp = one;
                one = one.next;
            } else {
                temp = another;
                another = another.next;
            }
            temp.next = null;
            node.next = temp;
            node = node.next;
        }

        while (one != null) {
            temp = one;
            one = one.next;
            temp.next = null;
            node.next = temp;
            node = node.next;
        }

        while (another != null) {
            temp = another;
            another = another.next;
            temp.next = null;
            node.next = temp;
            node = node.next;
        }
        return dummyhead.next;
    }

    public static void main(String[] args) {
        MergeTwoLinkedList mtll = new MergeTwoLinkedList();
        SinglyLinkedList one = new SinglyLinkedList(1);
        one.next =(new SinglyLinkedList(10));
        one.next.next = new SinglyLinkedList(20);
        one.next.next.next = new SinglyLinkedList(30);

        SinglyLinkedList another = new SinglyLinkedList(5);
        another.next = new SinglyLinkedList(15);
        another.next.next = new SinglyLinkedList(25);
        another.next.next.next = new SinglyLinkedList(35);

        System.out.println(mtll.merge(one, another));

    }
}
