package com.xl.algo.deepdive.queue;

public class CircularQueue<T> {
    private Object[] data;
    private int head;
    private int tail;

    public CircularQueue(int capacity) {
        data = new Object[capacity + 1];
    }

    public boolean enqueue(T elem) {
        if (isFull()) {
            return false;
        } else {
            data[tail] = elem;
            tail = (tail + 1) % data.length;
            return true;
        }
    }

    public boolean enqueueFront(T elem) {
        if (isFull()) {
            return false;
        } else {
            head = (head - 1 + data.length) % data.length;
            data[head] = elem;
            return true;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            T temp = (T) data[head];
            head = (head + 1) % data.length;
            return temp;
        }
    }

    public boolean dequeuRear() {
        if (isEmpty()) {
            return false;
        } else {
            tail = (tail - 1 + data.length) % data.length;
            return true;
        }
    }

    public T getRear() {
        if (isEmpty()) {
            return null;
        } else {
            return (T) data[(tail - 1 + data.length) % data.length];
        }
    }

    public T getFront() {
        if (isEmpty()) {
            return null;
        } else {
            return (T) data[head];
        }
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % data.length == head;
    }

    public static void main(String[] agrs) {
        CircularQueue circularDeque = new CircularQueue(3); // set the size to be 3
        System.out.println(circularDeque.enqueue(1));			// return true
        System.out.println(circularDeque.enqueue(2));			// return true
        System.out.println(circularDeque.enqueueFront(3));			// return true
        System.out.println(circularDeque.enqueueFront(4));			// return false, the queue is full
        System.out.println(circularDeque.getRear());  			// return 2
        System.out.println(circularDeque.isFull());				// return true
        System.out.println(circularDeque.dequeuRear());			// return true
        System.out.println(circularDeque.enqueueFront(4));			// return true
        System.out.println(circularDeque.getFront());			// return 4
    }

}
