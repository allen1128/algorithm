package com.xl.algo.deepdive.linkedlist;

public class DoublyLinkedList {
    private int data;
    DoublyLinkedList next;
    DoublyLinkedList prev;

    public DoublyLinkedList(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoublyLinkedList getNext() {
        return next;
    }

    public void setNext(DoublyLinkedList next) {
        this.next = next;
    }

    public DoublyLinkedList getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedList prev) {
        this.prev = prev;
    }

    public static DoublyLinkedList addAfter(DoublyLinkedList root, int target, int data) {
        DoublyLinkedList node = DoublyLinkedList.find(root, target);

        if (node != null) {
            DoublyLinkedList nn = node.next;
            DoublyLinkedList newNode = new DoublyLinkedList(data);
            node.next = newNode;
            newNode.prev = node;
            newNode.next = nn;

            if (nn != null) {
                nn.prev = newNode;
            }
        }

        return root;
    }

    public static DoublyLinkedList find(DoublyLinkedList root, int target) {
        DoublyLinkedList node = root;
        if (node == null) {
            return null;
        }

        while (node != null) {
            if (node.data == target) {
                break;
            }
            node = node.next;
        }
        return node;
    }

    public static DoublyLinkedList remove(DoublyLinkedList root, int target) {
        DoublyLinkedList node = find(root, target);

        if (node == root && node.next == null) {
            return null;
        }

        if (node != null) {
            if (node.next != null && node.prev != null) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            } else if (node.next != null) {
                node.next.prev = node.prev;
                root = node.next;
            } else {
                node.prev.next = null;
            }
        }
        return root;
    }

    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }

    public static void main(String[] args) {
        DoublyLinkedList root = new DoublyLinkedList(1);;
        root.next = new DoublyLinkedList(2);
        root.next.next = new DoublyLinkedList(3);
        root.next.prev = root;
        root.next.next.prev = root.next;

        root = DoublyLinkedList.addAfter(root, 2, 4);
        System.out.println(root);

        root = DoublyLinkedList.remove(root, 4);
        System.out.println(root);

        root = DoublyLinkedList.remove(root, 3);
        System.out.println(root);

        root = DoublyLinkedList.remove(root, 1);
        System.out.println(root);

        root = DoublyLinkedList.remove(root, 2);
        System.out.println(root);

    }
}
