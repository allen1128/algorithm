package com.xl.algo.deepdive.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DFSTopologySort {
    //adj table a -> b, b is depended on a; a is executed before b
    //for dfs, we need to revert the adj table, so that a is executed first.

    public List<Integer> sort(WeightedGraphA graph) {
        int v = graph.getV();
        List<Integer>[] revertAdj = new LinkedList[v];
        for (int i = 0; i < revertAdj.length; i++) {
            revertAdj[i] = new LinkedList<>();
        }

        for (int i = 0; i < v; i++) {
            for (WeightedGraphA.Edge edge : graph.getAdj()[i]) {
                revertAdj[edge.endId].add(edge.fromId);
            }
        }

        boolean[] visited = new boolean[v];
        List<Integer> traveral = new ArrayList<>();

        for (int i = 0; i < revertAdj.length; i++) {
            if (!visited[i]) {
                dfs(visited, revertAdj, i, traveral);
            }
        }

        return traveral;
    }

    private void dfs(boolean[] visited, List<Integer>[] revertAdj, int vertext, List<Integer> traversal) {
        visited[vertext] = true;
        for (int i = 0; i < revertAdj[vertext].size(); i++) {
            Integer next = revertAdj[vertext].get(i);
            if (!visited[next]) {
                visited[next] = true;
                dfs(visited, revertAdj, next, traversal);
            }
        }
        traversal.add(vertext);
    }

    public static void main(String[] args) {
        WeightedGraphA graph = new WeightedGraphA(5);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(4, 0, 1);
        DFSTopologySort dfs = new DFSTopologySort();
        System.out.println(dfs.sort(graph));
    }
}
