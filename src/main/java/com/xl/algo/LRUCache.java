package com.xl.algo;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    private HashMap<Integer, Integer> data = new HashMap<>();
    private LinkedList<Integer> order = new LinkedList<>();

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer result = data.get(key);
        if (result != null) {
            order.remove(Integer.valueOf(key));
            order.addFirst(key);
            return result;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (data.size() == capacity && (data.get(key) == null || data.get(key) != value)){
            data.remove(order.removeLast());
        }

        data.put(key, value);
        order.addFirst(key);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
