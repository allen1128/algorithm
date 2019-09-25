package com.xl.algo;

public class PartitionLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode reorderList(ListNode listNode, int x) {
        ListNode dummy1 = new ListNode(-1, null);
        ListNode curr1 = dummy1;
        ListNode dummy2 = new ListNode(-1, null);
        ListNode curr2 = dummy2;

        while (listNode != null) {
            if (listNode.val > x) {
                curr1.next = listNode;
                curr1 = listNode;
            } else {
                curr2.next = listNode;
                curr2 = listNode;
            }

            listNode = listNode.next;
        }
        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3, null);
        listNode.next = new ListNode(-1, null);
        listNode.next.next = new ListNode(6, null);
        listNode.next.next.next = new ListNode(-2, null);
        listNode.next.next.next.next = new ListNode(10, null);

        listNode = reorderList(listNode, 1);
        System.out.println(listNode);
    }
}
