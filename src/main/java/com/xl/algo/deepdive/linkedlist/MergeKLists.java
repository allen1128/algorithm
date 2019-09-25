package com.xl.algo.deepdive.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKLists {
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

    public ListNode merge(ListNode [] lists) {
        if (lists.length == 0) {
            return null;
        }

        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val > o2.val ? 1 : -1;
            }
        });

        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode node = dummyHead;

        while (!queue.isEmpty()) {
            ListNode node1 = queue.poll();
            if (node1.next != null) {
                queue.offer(node1.next);
            }
            node.next = node1;
            node1.next = null;
            node = node.next;
        }

        return dummyHead.next;
    }


    public static void main(String[] args) {
        MergeKLists mkl = new MergeKLists();
        ListNode[] listNodes = new ListNode[2];
        ListNode node = new ListNode(1);
        node.next = new ListNode(20);
        ListNode node2 = new ListNode(11);
        listNodes[0] = node;
        listNodes[1] = node2;
        System.out.println(mkl.merge(listNodes));
    }
}
