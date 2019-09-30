package com.xl.algo.deepdive.heap;

import java.util.Comparator;

public class Heap<T> {
    private T[] elements;
    private int capacity;
    private int count;
    private Comparator<? super T> comparator; //todo, understand this

    public Heap(int capacity, Comparator<? super T> comparator) {
        this.capacity = capacity;
        this.elements = (T[]) new Object[capacity + 1];
        this.count = 0;
        this.comparator = comparator;
    }

    public int getCount() {
        return count;
    }

    public boolean insert(T data) {
        if (count >= capacity) {
            return false;
        }
        elements[++count] = data;
        int i = count;

        while (i / 2 > 0 && comparator.compare(elements[i], elements[i / 2]) > 0) {
            swap(elements, i, i / 2);
            i /= 2;
        }
        return true;
    }

    public T pop() {
        if (count <= 0) {
            return null;
        }
        T max = elements[1];
        elements[1] = elements[count];
        elements[count] = null;
        count--;
        heapify(elements, count, 1);
        return max;
    }

    public T peek() {
        if (count <= 0) {
            return null;
        }
        return elements[1];
    }

    public void heapify(T[] elements, int count, int i) {
        while (true) {
            int maxPos = i;
            maxPos = i * 2 <= count && comparator.compare(elements[i * 2], elements[maxPos]) > 0
                    ? i * 2
                    : maxPos;
            maxPos = (i * 2 + 1) <= count && comparator.compare(elements[i * 2 + 1], elements[maxPos]) > 0
                    ? i * 2 + 1
                    : maxPos;
            if (maxPos == i) {
                break;
            }
            swap(elements, i, maxPos);
            i = maxPos;
        }
    }

    public void swap(T[] elements, int x, int y) {
        T temp = elements[x];
        elements[x] = elements[y];
        elements[y] = temp;
    }

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(10,  (o1, o2) -> o1.compareTo(o2));
        heap.insert(1);
        heap.insert(5);
        heap.insert(35);
        heap.insert(25);
        heap.insert(55);
        heap.insert(-155);
        System.out.println(heap.pop());
        System.out.println(heap.pop());
    }
}
