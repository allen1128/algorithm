package com.xl.algo.deepdive.array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortedArrayTest {
    @Test
    public void add() throws Exception {
        SortedArray sa = new SortedArray(10);
        sa.add(2);
        sa.add(3);
        sa.add(7);
        sa.add(1);
        sa.add(0);
        sa.add(6);
        sa.add(2);
        sa.add(3);
        sa.add(7);
        sa.add(1);

        sa.remove(2);
        sa.remove(3);
        sa.remove(7);
        sa.remove(1);
        sa.remove(0);
        sa.remove(6);
        sa.remove(2);
        sa.remove(3);
        sa.remove(7);
        sa.remove(1);

        System.out.println(sa.toString());
    }

}