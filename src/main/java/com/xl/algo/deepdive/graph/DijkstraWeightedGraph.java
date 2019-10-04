package com.xl.algo.deepdive.graph;

import com.xl.algo.deepdive.heap.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.xl.algo.deepdive.graph.WeightedGraphA.Vertex;
import com.xl.algo.deepdive.graph.WeightedGraphA.Edge;

public class DijkstraWeightedGraph {

    private WeightedGraphA graph;

    private Heap<Vertex> heap;

    public DijkstraWeightedGraph(int v) {
        this.graph = new WeightedGraphA(v);
        this.heap = new Heap<>(v, (o1, o2) -> o1.getDist() < o2.getDist() ? 1 : -1);
    }

    public List<Integer> dijkstra(int i, int j) {


        int[] prev = new int[graph.getV()];
        Arrays.fill(prev, -1);

        Vertex[] vertices = new Vertex[graph.getV()];

        for (int k = 0; k < vertices.length; k++) {
            vertices[k] = new Vertex(k, Integer.MAX_VALUE);
        }
        vertices[i] = new Vertex(i, 0);
        List<Integer> result = helper(i, j, prev, vertices);
        return result;
    }

    private List<Integer> helper(int i, int j, int[] prev, Vertex[] vertices) {
        heap.insert(vertices[i]);
        List<Integer> steps = new ArrayList<>();
        boolean[] inqueue = new boolean[vertices.length];

        while (!heap.isEmpty()) {
            Vertex minVertex = heap.pop();
            if (minVertex.vertexId == j) {
                getSteps(i, j, prev, steps);
                return steps;
            } else {
                for (Edge neighbor : graph.getAdj()[minVertex.vertexId]) {
                    int newDist = minVertex.dist + neighbor.weight;

                    Vertex nextVertex = vertices[neighbor.endId];
                    if (newDist < nextVertex.dist) {
                        nextVertex.dist = newDist;
                        prev[nextVertex.getVertexId()] = minVertex.getVertexId();
                        if (inqueue[neighbor.endId]) {
                            heap.update(nextVertex);
                        } else {
                            heap.insert(nextVertex);
                            inqueue[neighbor.endId] = true;
                        }
                    }
                }
            }
        }
        return steps;
    }

    public List<Integer> getSteps(int src, int dest, int[] prev, List<Integer> steps) {
        if (src == dest) {
            steps.add(0, dest);
            return steps;
        } else if (prev[dest] != -1) {
            steps.add(0, dest);
            return getSteps(src, prev[dest], prev, steps);
        } else {
            return Collections.emptyList();
        }
    }

    public static void main(String[] args) {
        List<Edge>[] edges = new LinkedList[3];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new LinkedList<>();
        }

        DijkstraWeightedGraph spig = new DijkstraWeightedGraph(3);
        spig.graph.addEdge(0, 1, 1);
        spig.graph.addEdge(0, 2, 7);
        spig.graph.addEdge(1, 2, 5);
        System.out.println(spig.dijkstra(0, 2));
    }
}
