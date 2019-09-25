package com.xl.algo.deepdive.hashmap;

import java.util.Arrays;

public class HashMap<K, V> {

    private static final int DEFAULT_INIT_CAPACITY = 30;
    private static final float LOAD_FACTOR = 0.7f;
    private Entry<K, V>[] nodes;
    private int capacity;
    private int size = 0;

    public class Entry<K, V> {
        K key;
        V value;
        Entry next;

        public Entry(K key, V value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public HashMap() {
        this(DEFAULT_INIT_CAPACITY);
    }

    public HashMap(int c) {
        nodes = new Entry[c];
        this.capacity = c;
    }

    public void put(K key, V value) {
        int index = key.hashCode() % nodes.length;
        Entry<K, V> entry = nodes[index];

        if (entry == null) {
            nodes[index] = new Entry(key, value, null);
        } else {
            while (entry != null) {
                if (entry.key == key) {
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            nodes[index] = new Entry(key, value, nodes[index]);
        }

        if (++size >= capacity * LOAD_FACTOR) {
            growSize();
        }
    }

    public boolean remove(K key) {
        boolean result = false;
        int index = key.hashCode() % nodes.length;
        Entry<K, V> entry = nodes[index];
        if (entry == null) {
            return result;
        } else {
            Entry prev = null;
            while (entry != null) {
                if (entry.key == key) {
                    break;
                } else {
                    prev = entry;
                }
                entry = entry.next;
            }
            if (prev != null) {
                if (entry != null) { //entry found and not at the first pos
                    prev.next = entry.next;
                    result = true;
                    size--;
                }
            } else {
                if (entry != null) { //entry found at the first pos
                    nodes[index] = entry.next;
                    result = true;
                    size--;
                }
            }
        }
        return result;
    }

    private void growSize() {
        capacity = capacity * 2;
        nodes = Arrays.copyOf(nodes, capacity);
    }

    public V get(K key) {
        int index = key.hashCode() % nodes.length;
        Entry<K, V> entry = nodes[index];

        while (entry != null && entry.key != key) {
            entry = entry.next;
        }
        return entry == null ? null : entry.value;
    }

    public boolean containsKey(K key) {
        int index = key.hashCode() % nodes.length;
        Entry<K, V> entry = nodes[index];

        while (entry != null && entry.key != key) {
            entry = entry.next;
        }
        return entry != null;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>(3);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        System.out.println("size:" + map.size);
        map.remove(2);
        System.out.println("size:" + map.size);
        map.remove(1);
        System.out.println("size:" + map.size);
        map.put(4, 4);
        System.out.println("size:" + map.size);
    }
}
