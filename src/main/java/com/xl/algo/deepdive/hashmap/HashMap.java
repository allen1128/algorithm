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
        Entry<K, V>[] oldTables = nodes;
        nodes = new Entry[nodes.length * 2];
        capacity = nodes.length;
        size = 0;
        for (int i = 0; i < oldTables.length; i++) {
            if (oldTables[i] == null) {
                continue;
            }

            Entry<K, V> entry = oldTables[i];
            while (entry != null) {
                int index = entry.key.hashCode() % nodes.length;
                if (nodes[index] == null) {
                    nodes[index] = new Entry(entry.key, entry.value, null);
                } else {
                    nodes[index] = new Entry(entry.key, entry.value, nodes[index]);
                }
                size++;
                entry = entry.next;
            }
        }
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
        map.put(0, 0);
        map.put(3, 3);
        map.put(6, 6);
        map.put(9, 9);
        map.put(12, 12);
        map.remove(0);
        System.out.println(map.get(0));
        System.out.println(map.get(0));
    }
}
