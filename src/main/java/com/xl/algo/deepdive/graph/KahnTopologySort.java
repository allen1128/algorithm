package com.xl.algo.deepdive.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.xl.algo.deepdive.graph.WeightedGraphA.Edge;

public class KahnTopologySort {
    public List<Integer> sort(WeightedGraphA graph) {
        int[] indegree = new int[graph.getV()];
        for (int i = 0; i < graph.getAdj().length; i++) {
            for (Edge edge : graph.getAdj()[i]) {
                indegree[edge.endId]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer vert = queue.poll();
            result.add(vert);

            for (Edge edge : graph.getAdj()[vert]) {
                indegree[edge.endId]--;
                if (indegree[edge.endId] == 0) {
                    queue.offer(edge.endId);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        KahnTopologySort ts = new KahnTopologySort();
        WeightedGraphA graph = new WeightedGraphA(5);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(4, 0, 1);
//        graph.addEdge(0, 1, 1);
//        graph.addEdge(0, 2, 1);
//        graph.addEdge(1, 2, 1);
//        graph.addEdge(2, 3, 1);
//        graph.addEdge(1, 3, 1);
        System.out.println(ts.sort(graph));
    }
}
