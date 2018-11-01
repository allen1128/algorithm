package com.xl.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllSubsetGivenAListOfInteger {
    //unique elements in subsets
    public void solve2(Integer i, List<Integer> list, List<Integer> path, List<List<Integer>> paths, Set<Integer> used) {
        List<List<Integer>> ans = new ArrayList<>();

        if (i == list.size()) {
            return;
        }

        for (int j = i; j < list.size(); j++) {
            if ((j == 0 || list.get(j) != list.get(j-1)) && !used.contains(list.get(j))) {
                path.add(list.get(j));
                paths.add(new ArrayList<>(path));
                used.add(list.get(j));
                solve2(j + 1, list, path, paths, used);
                path.remove(path.size() - 1);
                used.remove(new Integer(list.get(j)));
            }
        }
    }

    //unique subsets
    public void solve(Integer i, List<Integer> list, List<Integer> path, List<List<Integer>> paths) {
        List<List<Integer>> ans = new ArrayList<>();

        if (i == list.size()) {
            return;
        }

        for (int j = i; j < list.size(); j++) {
            if (j == i || list.get(j) != list.get(j - 1)) {
                path.add(list.get(j));
                paths.add(new ArrayList<>(path));
                solve(j + 1, list, path, paths);
                path.remove(path.size() - 1);
            } else {
                //System.out.println(path);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(4); list.add(4);
        Collections.sort(list);
        AllSubsetGivenAListOfInteger a = new AllSubsetGivenAListOfInteger();
        List<List<Integer>> paths = new ArrayList<>();

        a.solve2(0, list, new ArrayList<>(), paths, new HashSet<Integer>() );
        System.out.println(paths);
    }
}
