package com.xl.algo.deepdive.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {
    @Test
    public void add() {
        NewArrayList<Integer> al = new NewArrayList<>(2);
        al.add(1);
        al.add(2);
        al.add(3);
        assertTrue(al.size() == 3);
        assertTrue(al.capacity() == 4);
    }

    @Test
    public void add1() throws Exception {
        NewArrayList<Integer> al = new NewArrayList<>(2);
        al.add(0, 0);
        al.add(1, 1);
        try {
            al.add(2, 2);
            fail("should thrown exception");
        } catch (IndexOutOfBoundsException ex) {
        }
        assertTrue(al.size() == 2);
        assertTrue(al.capacity() == 4);
    }

    @Test
    public void get() throws Exception {
        NewArrayList<Integer> al = new NewArrayList<>(2);
        al.add(0, 0);
        al.add(1, 1);
        assertTrue(al.get(0).equals(0));

    }

    @Test
    public void remove() throws Exception {
        NewArrayList<Integer> al = new NewArrayList<>(2);
        try {
            al.remove(0);
            fail("should  thrown exception");
        } catch (IndexOutOfBoundsException ex) {}

        al.add(-1);
        al.remove(0);
        assertTrue(al.size() == 0);
    }

    @Test
    public void remove1() throws Exception {
        NewArrayList<Integer> al = new NewArrayList<>(2);
        al.add(0);
        al.remove(new Integer(0));
        assertTrue(al.size() == 0);
    }

    @Test
    public void addLotsOfItems() throws Exception {
        NewArrayList<Integer> al = new NewArrayList<>(2);
        for (int i = 0 ; i < 100; i++) {
            al.add(i);
        }
        assertTrue(al.size() == 100);
    }


}