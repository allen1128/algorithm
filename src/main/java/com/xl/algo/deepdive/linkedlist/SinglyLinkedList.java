package com.xl.algo.deepdive.linkedlist;

public class SinglyLinkedList {
    public int data;
    public SinglyLinkedList next;

    public SinglyLinkedList(int data) {
        this.data = data;
    }

    public SinglyLinkedList(int data, SinglyLinkedList next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SinglyLinkedList getNext() {
        return next;
    }

    public void setNext(SinglyLinkedList next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }

    public static SinglyLinkedList remove(int target, SinglyLinkedList root) {
        SinglyLinkedList prev = null;
        SinglyLinkedList node = root;

        while (node != null) {
            if (node.data == target) {
                break;
            }
            prev = node;
            node = node.next;
        }

        if (node != null) {
            if (prev != null) {
                prev.next = node.next;
            } else {
                root = node.next;
            }
        }
        return root;
    }

    public static SinglyLinkedList appendAfter(int after, int data, SinglyLinkedList root) {
        SinglyLinkedList newNode = new SinglyLinkedList(data);
        SinglyLinkedList node = root;

        while (node != null) {
            if (node.data == after) {
                break;
            }
            node = node.next;
        }

        if (node != null) {
            SinglyLinkedList temp = node.next;
            node.next = newNode;
            newNode.next = temp;
        } else {
            throw new IndexOutOfBoundsException("element not found=" + after);
        }
        return root;
    }

    public static SinglyLinkedList appendLast(int data, SinglyLinkedList root) {
        SinglyLinkedList newNode = new SinglyLinkedList(data);
        if (root == null) {
            return newNode;
        }

        SinglyLinkedList prev = null;
        SinglyLinkedList node = root;

        while (node != null) {
            prev = node;
            node = node.next;
        }

        prev.next = newNode;
        return root;
    }


    public static void main(String[] args) {
        SinglyLinkedList node = new SinglyLinkedList(3);
        node.next = new SinglyLinkedList(4);
        node.next.next = new SinglyLinkedList(5);

        System.out.println(node);
        node = SinglyLinkedList.remove(3, node);
        SinglyLinkedList.appendLast(11, node);
        SinglyLinkedList.appendLast(12, node);
        SinglyLinkedList.appendLast(13, node);
        SinglyLinkedList.appendAfter(5, 10, node);
        System.out.println(node);
    }
}
