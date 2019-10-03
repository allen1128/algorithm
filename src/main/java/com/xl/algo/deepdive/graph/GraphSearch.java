package com.xl.algo.deepdive.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphSearch {
    public int steps(OrientedGraph orientedGraph, int src, int dest) {
        int step = 0;
        if (src == dest) {
            return step;
        }

        int[] visited = new int[orientedGraph.getSize()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            step++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> neighbors = orientedGraph.getNeighbors(queue.poll());
                if (neighbors.contains(dest)) {
                    return step;
                }
                queue.addAll(neighbors);
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        OrientedGraph og = new OrientedGraph(5, false);
        og.addEdge(0, 1);
        og.addEdge(1, 2);
        og.addEdge(2,3);
        og.addEdge(3,4);
        og.addEdge(4,1);
        og.addEdge(3,0);

        GraphSearch gf = new GraphSearch();
        System.out.println(gf.steps(og, 3, 2));
    }


}
