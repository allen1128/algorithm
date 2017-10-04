package com.xl.algo;

public class ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = head;

        if (head == null || head.next == null) {
            return prev;
        }

        ListNode next = head.next;
        head.next = null;

        while (next != null) {
            ListNode temp = next.next;
            next.next = prev;
            prev = next;
            next = temp;
        }

        return prev;
    }
}
