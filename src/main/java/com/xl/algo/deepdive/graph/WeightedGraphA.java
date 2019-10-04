package com.xl.algo.deepdive.graph;

import java.util.LinkedList;
import java.util.List;

public class WeightedGraphA {
    private List<Edge>[] adj;
    private int v;

    public WeightedGraphA(int v) {
        this.v = v;
        this.adj = new LinkedList[v];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
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

    public List<Edge>[] getAdj() {
        return adj;
    }

    public int getV() {
        return v;
    }
}
