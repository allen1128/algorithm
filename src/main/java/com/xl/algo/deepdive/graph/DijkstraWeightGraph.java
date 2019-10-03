package com.xl.algo.deepdive.graph;

import com.xl.algo.deepdive.heap.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DijkstraWeightGraph {
    List<Edge>[] adj;
    Heap<Vertex> heap;
    int v;

    public DijkstraWeightGraph(int v) {
        this.v = v;
        heap = new Heap<>(v, (o1, o2) -> o1.getDist() < o2.getDist() ? 1 : -1);
        adj = new ArrayList[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int s, int t, int w) {
        adj[s].add(new Edge(s, t, w));
    }

    public static class Vertex {
        int vertexId;
        int dist;

        public Vertex(int vertexId, int dist) {
            this.vertexId = vertexId;
            this.dist = dist;
        }

        public int getVertexId() {
            return vertexId;
        }

        public int getDist() {
            return dist;
        }

        public void setDist(int dist) {
            this.dist = dist;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Vertex vertex = (Vertex) o;

            return vertexId == vertex.vertexId;
        }

        @Override
        public int hashCode() {
            return vertexId;
        }
    }

    public static class Edge {
        int fromId;
        int endId;
        int weight;

        public Edge(int fromId, int endId, int weight) {
            this.fromId = fromId;
            this.endId = endId;
            this.weight = weight;
        }
    }

    public List<Integer> dijkstra(int i, int j) {
        int[] prev = new int[v];
        Arrays.fill(prev, -1);
        Vertex[] vertices = new Vertex[v];

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
            Vertex minVertext = heap.pop();
            if (minVertext.vertexId == j) {
                getSteps(i, j, prev, steps);
                return steps;
            } else {
                for (Edge neighbor : adj[minVertext.vertexId]) {
                    int newDist = minVertext.dist + neighbor.weight;

                    Vertex nextVertex = vertices[neighbor.endId];
                    if (newDist < nextVertex.dist) {
                        nextVertex.dist = newDist;
                        prev[nextVertex.getVertexId()] = minVertext.getVertexId();
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
        List<Edge>[] edges = new ArrayList[3];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }

        DijkstraWeightGraph spig = new DijkstraWeightGraph(3);
        spig.addEdge(0, 1, 1);
        spig.addEdge(0, 2, 6);
        spig.addEdge(1, 2, 5);
        System.out.println(spig.dijkstra(0, 2));
    }
}
