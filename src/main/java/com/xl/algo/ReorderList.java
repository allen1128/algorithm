package com.xl.algo;

import org.omg.PortableServer.RequestProcessingPolicyOperations;

import java.util.List;

public class ReorderList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        //find the second half
        ListNode chaser = head;
        ListNode runner = head;

        while (chaser.next != null && runner.next != null && runner.next.next != null) {
            chaser = chaser.next;
            runner = runner.next.next;
        }

        ListNode head2 = chaser.next;
        chaser.next = null;

        //reverse the second half
        ListNode node = head2;
        ListNode prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }

        head2 = prev;
        //interwine them
        ListNode dummHead = new ListNode(-1);
        node = dummHead;

        //TODO: always look at the commented code to see how the mistake was made
//        while (head != null && head2 != null) {
//            node.next = head;
//            node.next.next = head2;
//            head = head.next;
//            head2 = head2.next;
//            node = node.next.next;
//        }


        while (head != null && head2 != null) {
            node.next = head;
            node = node.next;
            head = head.next;

            node.next = head2;
            node = node.next;
            head2 = head2.next;
        }


        if (head != null) {
            node.next = head;
        } else if (head2 != null) {
            node.next = head2;
        }

    }

    public static void main(String[] args) {
        ReorderList rl = new ReorderList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        rl.reorderList(head);
        System.out.println(head);
    }
}
