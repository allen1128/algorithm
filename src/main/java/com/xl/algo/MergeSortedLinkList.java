package com.xl.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeSortedLinkList {
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

    public ListNode merge(List<ListNode> listNodes) {
        ListNode dummyHead = new ListNode(-1, null);
        ListNode node = dummyHead;

        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for (int i = 0; i < listNodes.size(); i++) {
            queue.add(listNodes.get(i));
        }

        while (queue.size() > 0) {
            ListNode n = queue.poll();
            if (n.next != null) {
                queue.offer(n.next);
            }
            node.next = n;
            node = node.next;
        }

        return dummyHead.next;
    }

    public ListNode merge2(List<ListNode> listNodes) {
        Queue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val < o2.val ? -1 : 1;
            }
        });

        listNodes.stream().filter(l -> l != null).forEach(listNode -> pq.add(listNode));
        ListNode dummy = new ListNode(-1, null);
        ListNode head = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            head.next = node;
            head = head.next;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        List<ListNode> listNodes = new ArrayList<>();

        ListNode head1 = new ListNode(-1, null);
        head1.next = new ListNode(2, null);
        head1.next.next = new ListNode(13, null);

        ListNode head2 = new ListNode(-10, null);
        head2.next = new ListNode(0, null);
        head2.next.next = new ListNode(1, null);

        ListNode head3 = new ListNode(-5, null);
        head3.next = new ListNode(0, null);
        head3.next.next = new ListNode(5, null);

        ListNode head4 = new ListNode(-5, null);



        listNodes.add(null);
        listNodes.add(head4);

        MergeSortedLinkList ms = new MergeSortedLinkList();
        ListNode node = ms.merge2(listNodes);
        System.out.println(node);

        ListNode dummyHead = new ListNode(-1, null);
        ListNode node2 = dummyHead.next;
        dummyHead.next = new ListNode(2, null);
        System.out.println(node2);

    }
}
