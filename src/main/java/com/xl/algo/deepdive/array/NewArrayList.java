package com.xl.algo.deepdive.array;

import java.util.Arrays;

public class NewArrayList<T> {
    private Object[] data;
    private int capacity;
    private int size = 0;
    private final int DEFAULT_SIZE = 32;

    public NewArrayList(){
        data = new Object[DEFAULT_SIZE];
        capacity = DEFAULT_SIZE;
    }

    public NewArrayList(int size) {
        data = new Object[size];
        capacity = size;
    }

    public void add(T object) {
        growCapacity();
        data = Arrays.copyOf(data, capacity);
        System.out.println("size:" + size);
        data[size++] = object;
    }

    public void add(int index, T object) {
        rangeCheckForAdd(index);
        growCapacity();
        System.arraycopy(data, index, data, index+1, size - index );
        data[index] = object;
        size++;
    }

    public T get(int index) {
        return (T) data[index];
    }

    public T remove(int index) {
        rangeCheck(index);
        Object temp = data[index];
        int numMoved = size - index - 1;

        System.arraycopy(data, index + 1, data, index, numMoved);
        size--;
        return (T) temp;
    }

    public void remove(T object) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(object)) {
                remove(i);
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }


    private void rangeCheckForAdd(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException(String.format("index out of bound=%s", size -1));
        }
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(String.format("index out of bound=%s", size -1));
        }
    }

    private void growCapacity() {
        if (size + 1 >= capacity) {
            capacity *= 2;
        }
    }

}
