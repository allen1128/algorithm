package com.xl.algo;

import java.util.*;

public class AddTwoLinkedList {

    static public class ListNode {
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

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode revL1 = reverseList(l1);
        ListNode revL2 = reverseList(l2);
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;

        int carryover = 0;

        while (revL1 != null || revL2 != null){
            int l1Val = revL1 != null ? revL1.val : 0;
            int l2Val = revL2 != null ? revL2.val : 0;
            int val = l1Val + l2Val + carryover;
            carryover = val / 10;
            int reminder = val % 10;
            curr.next = new ListNode(reminder);
            curr = curr.next;

            revL1 = revL1 != null ? revL1.next : null;
            revL2 = revL2 != null ? revL2.next : null;
        }

        if (carryover > 0){
            curr.next = new ListNode(carryover);
        }

        return reverseList(dummyHead.next);
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        int[] test;
        List<String> test2 = new ArrayList<String>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carryover = 0;

        ListNode next = null;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int val1 = !stack1.isEmpty() ? stack1.pop() : 0;
            int val2 = !stack2.isEmpty() ? stack2.pop() : 0;
            int val = val1 + val2 + carryover;
            int digit = val % 10;
            carryover = val / 10;
            ListNode node = new ListNode(digit);
            node.next = next;
            next = node;
        }

        if (carryover > 0) {
            ListNode node = new ListNode(carryover);
            node.next = next;
            next = node;
        }

        return next;

    }

    public static void main(String[] args) {
        AddTwoLinkedList atll = new AddTwoLinkedList();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(7);

        ListNode node2 = new ListNode(8);
        node2.next = new ListNode(3);

        System.out.println(atll.addTwoNumbers2(node1, node2));
        

        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
    }
}
