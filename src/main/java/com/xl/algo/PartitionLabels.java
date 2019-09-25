package com.xl.algo;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int[] last = new int[26];

        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        int max = 0;
        int partition = 0;
        for (int i = 0; i < S.length(); i++) {
            max = Math.max(max, last[S.charAt(i) - 'a']);
            if (max == i) {
                result.add(i + 1 - partition);
                partition = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PartitionLabels pl = new PartitionLabels();
        System.out.println(pl.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
