package com.xl.algo.deepdive.array;

import java.util.Arrays;

public class SortedArray {
    private int[] data;
    private int capacity;
    private int size = 0;

    public SortedArray(int capacity) {
        data = new int[capacity];
        this.capacity = capacity;
    }

    public void add(int d) {
        int index = findIndexOfForAdd(d);
        add(index, d);
    }

    public void add(int index, int d) {
        rangeCheckForAdd(index);
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = d;
        size++;
    }

    private void rangeCheckForAdd(int index) {
        if (index > data.length) {
            throw new IndexOutOfBoundsException();
        }
        rangeCheck(index);
    }

    private void rangeCheck(int index) {
        if (index >= capacity) {
            throw new IllegalStateException("over capacity");
        }
    }

    public int remove(int d) {
        int index = findIndexOfForDelete(d);
        if (index == -1) {
            return -1;
        }
        int temp = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return temp;
    }

    //find the first element which is equal to or larger than target.
    private int findIndexOfForAdd(int target) {
        if (size == 0) {
            return size;
        }
        int left = 0;
        int right = size - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) /2;
            if (data[mid] > target) {
                right = mid - 1;
            } else if (data[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        if (data[left] >= target) {
            return left;
        } else if (data[right] >= target) {
            return right;
        } else {
            return size;
        }

    }

    private int findIndexOfForDelete(int target) {
        int left = 0;
        int right = size - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (data[mid] > target) {
                right = mid - 1;
            } else if (data[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        if (data[left] == target) {
            return left;
        } else if (data[right] == target) {
            return right;
        } else {
            return -1;
        }

    }

    public int[] getData() {
        return data;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        return "SortedArray{" +
                "data=" + sb.toString() +
                ", capacity=" + capacity +
                ", size=" + size +
                '}';
    }
}
