package com.xl.algo;

import java.util.HashMap;
import java.util.Map;


public class CopyListWithRandomPointer {
    public static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    };


    public static Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

    public static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummyhead = new RandomListNode(-1);
        RandomListNode curr = dummyhead;

        while(head != null){
            if (map.containsKey(head)) {
                curr.next = map.get(head);
            } else {
                RandomListNode node = new RandomListNode(head.label);
                map.put(head, node);
                curr.next = node;
            }

            if (head.random != null){
                if (map.containsKey(head.random)){
                    curr.next.random = map.get(head.random);
                } else {
                    RandomListNode random = new RandomListNode(head.random.label);
                    curr.next.random = random;
                    map.put(head.random, random);
                }
            }
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
