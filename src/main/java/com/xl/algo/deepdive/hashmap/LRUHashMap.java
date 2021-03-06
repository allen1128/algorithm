package com.xl.algo.deepdive.hashmap;


import java.util.Map;
import java.util.HashMap;

public class LRUHashMap<K, V> {
    public static final float LOAD_FACTOR = 0.75f;

    private Map<K, DoublyLinkedNode> map;

    private DoublyLinkedNode header;

    private DoublyLinkedNode tailer;

    private int size;

    private int capacity;

    public LRUHashMap(int capacity) {
        header = new DoublyLinkedNode(null, null);
        tailer = new DoublyLinkedNode(null, null);
        header.setNext(tailer);
        tailer.setPrev(header);

        map = new HashMap<>(capacity, LOAD_FACTOR);
        this.capacity = capacity;
        size = 0;
    }

    public void put(K key, V value) {
        DoublyLinkedNode node = map.get(key);

        if (node == null) {
            size++;
            node = new DoublyLinkedNode(key, value);
            appendFront(node);
        } else {
            node.v = value;
            moveToHead(node);
        }

        map.put(key, node);

        if (size > capacity) {
            popTail();
        }
    }

    private void moveToHead(DoublyLinkedNode node) {
        if (node == null) {
            return;
        }
        remove(node);
        appendFront(node);
    }

    private void popTail() {
        if (size <= 0) {
            return;
        }
        map.remove(tailer.prev.k);
        remove(tailer.prev);
        size--;
    }

    public void remove(K key) {
        if (!map.containsKey(key)) {
            return;
        }

        DoublyLinkedNode node = map.get(key);
        remove(node);
        map.remove(key);
        size--;
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        DoublyLinkedNode node = map.get(key);
        remove(node);
        appendFront(node);
        return (V) map.get(key).v;
    }

    private void remove(DoublyLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void appendFront(DoublyLinkedNode node) {
        header.next.prev = node;
        node.next = header.next;
        node.prev = header;
        header.next = node;
    }

    public DoublyLinkedNode getHeader() {
        return header;
    }

    public static class DoublyLinkedNode<K, V> {
        DoublyLinkedNode prev;
        DoublyLinkedNode next;
        K k;
        V v;

        public DoublyLinkedNode(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public DoublyLinkedNode getPrev() {
            return prev;
        }

        public void setPrev(DoublyLinkedNode prev) {
            this.prev = prev;
        }

        public DoublyLinkedNode getNext() {
            return next;
        }

        public void setNext(DoublyLinkedNode next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DoublyLinkedNode<?, ?> that = (DoublyLinkedNode<?, ?>) o;

            if (!k.equals(that.k)) return false;
            return v != null
                    ? v.equals(that.v)
                    : that.v == null;
        }

        @Override
        public int hashCode() {
            int result = k.hashCode();
            result = 31 * result + (v != null
                    ? v.hashCode()
                    : 0);
            return result;
        }

        @Override
        public String toString() {
            return "DoublyLinkedNode{" +
                    "next=" + next +
                    ", k=" + k +
                    ", v=" + v +
                    '}';
        }
    }


    public static void main(String[] args) {
        LRUHashMap<Integer, Long> lruHashMap = new LRUHashMap<>(3);
        lruHashMap.put(1, 1l);
        lruHashMap.put(2, 2l);
        lruHashMap.put(3, 3l);
        System.out.println(lruHashMap.size);
        System.out.println(lruHashMap.getHeader());
        lruHashMap.get(1);
        System.out.println(lruHashMap.size);
        System.out.println(lruHashMap.getHeader());
        lruHashMap.put(4, 4l);
        lruHashMap.remove(4);
        lruHashMap.put(3, 33l);
        System.out.println(lruHashMap.size);
        System.out.println(lruHashMap.getHeader());
    }


}
