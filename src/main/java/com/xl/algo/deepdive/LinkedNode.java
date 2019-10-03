package com.xl.algo.deepdive;

public class LinkedNode<K> {
    private LinkedNode next;
    private K value;

    public LinkedNode(K k) {
        this.value = k;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    public K getValue() {
        return value;
    }

    public void add(LinkedNode node) {
        LinkedNode curr = this;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
    }

    public int size() {
        int count = 0;
        LinkedNode n = next;
        while (n != null) {
            count++;
            n = n.next;
        }
        return count;
    }

    public LinkedNode get(int i) {
        int count = 0;
        LinkedNode n = next;
        while (n != null) {
            if (count == i) {
                return n;
            }
            count++;
            n = n.next;
        }
        return null;
    }
}
