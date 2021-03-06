package com.xl.algo.deepdive.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

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
        heapifyUp(elements, count);
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
        heapifyDown(elements, count, 1);
        return max;
    }

    public T peek() {
        if (count <= 0) {
            return null;
        }
        return elements[1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void update(T element) {
        for (int i = 1; i <= count; i++) {
            if (elements[i].equals(element)) {
                elements[i] = element;
                heapifyDown(elements, count, i);
                heapifyUp(elements, i);
                break;
            }
        }
    }

    public void heapifyDown(T[] elements, int count, int i) {
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

    public void heapifyUp(T[] elements, int i) {
        while (i / 2 > 0 && comparator.compare(elements[i], elements[i / 2]) > 0) {
            swap(elements, i, i / 2);
            i /= 2;
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

        PriorityQueue<Integer> queu = new PriorityQueue<>();
        queu.offer(1);
        queu.offer(2);
        System.out.println(queu.poll());


    }
}
