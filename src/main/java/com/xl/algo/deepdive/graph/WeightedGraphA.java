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
