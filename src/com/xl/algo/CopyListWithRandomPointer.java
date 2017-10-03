package com.xl.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};

public class CopyListWithRandomPointer {
    public static Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

    public static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummyhead = new RandomListNode(-1);
        RandomListNode prev = dummyhead;

        while(head != null){
            if (map.containsKey(head)) {
                prev.next = map.get(head);
            } else {
                RandomListNode node = new RandomListNode(head.label);
                map.put(head, node);
                prev.next = node;
            }

            if (head.random != null){
                if (map.containsKey(head.random)){
                    prev.next.random = map.get(head.random);
                } else {
                    RandomListNode random = new RandomListNode(head.random.label);
                    prev.next.random = random;
                    map.put(head.random, random);
                }
            }

            head = head.next;
            prev = prev.next;
        }

        return dummyhead.next;
    }

    public static void main(String[] args) {
        RandomListNode node = new RandomListNode(1);
        node.next = new RandomListNode(2);
        node.next.next = new RandomListNode( 3);
        node.next.next.random = node.next;

        System.out.println(copyRandomList(node));
    }
}
