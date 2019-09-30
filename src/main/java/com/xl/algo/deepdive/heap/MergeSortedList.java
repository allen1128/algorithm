package com.xl.algo.deepdive.heap;

import com.xl.algo.ReorderList;
import com.xl.algo.deepdive.linkedlist.MergeKLists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedList {
    public static class SortedList {
        List<Integer> data;
        int index;

        public SortedList(List<Integer> data, int index) {
            this.data = data;
            this.index = index;
        }

        public boolean hasData() {
            return index < data.size();
        }

        public Integer get() {
            if (hasData()) {
                return data.get(index);
            } else {
                return null;
            }
        }

        public void increment(){
            index++;
        }
    }
    public static List<Integer> sort(List<List<Integer>> sortedlists) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<SortedList> priorityQueue = new PriorityQueue<>(new Comparator<SortedList>() {
            @Override
            public int compare(SortedList o1, SortedList o2) {
                if (!o1.hasData() && !o2.hasData()) {
                    return 0;
                } else if (!o1.hasData()) {
                    return -1;
                } else if (!o2.hasData()){
                    return 1;
                } else {
                    return o1.get().compareTo(o2.get());
                }
            }
        });

        for (List<Integer> list : sortedlists) {
            priorityQueue.add(new SortedList(list, 0));
        }

        while (priorityQueue.size() > 0) {
            SortedList sortedList = priorityQueue.poll();
            if (sortedList.hasData()) {
                result.add(sortedList.get());
                sortedList.increment();
                priorityQueue.offer(sortedList);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> sortedlists = new ArrayList<>();
        List<Integer> data1 = new ArrayList<>();
        data1.add(1);
        data1.add(2);
        data1.add(100);

        List<Integer> data2 = new ArrayList<>();
        data2.add(2);
        data2.add(3);
        data2.add(101);
        sortedlists.add(data1);
        sortedlists.add(data2);
        System.out.println(MergeSortedList.sort(sortedlists));
    }
}
