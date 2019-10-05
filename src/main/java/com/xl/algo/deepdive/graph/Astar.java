package com.xl.algo.deepdive.graph;

import com.xl.algo.deepdive.heap.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Astar {

    private WeightedGraphA graph;

    private Heap<Vertex> heap;

    private Vertex[] vertices;

    public Astar(int v, int[][] vertices) {
        this.graph = new WeightedGraphA(v);
        this.heap = new Heap<>(v, ((o1, o2) -> o1.f < o2.f ? 1 : -1));
        this.vertices = new Vertex[v];
        for (int i = 0; i < this.vertices.length; i++) {
            this.vertices[i] = new Vertex(i, vertices[i][0], vertices[i][1]);
        }
    }

    public static class Vertex {
        int id;
        int dist;
        int f;
        int x, y;

        public Vertex(int id, int x, int y) {
            this.id = id;
            this.dist = Integer.MAX_VALUE;
            this.f = Integer.MAX_VALUE;
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Vertex vertex = (Vertex) o;

            if (id != vertex.id) return false;
            if (dist != vertex.dist) return false;
            return f == vertex.f;
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + dist;
            result = 31 * result + f;
            return result;
        }
    }

    public List<Integer> astar(int s, int d){
        List<Integer> steps = new ArrayList<>();
        vertices[s].dist = 0;
        vertices[s].f = 0;
        heap.insert(vertices[s]);
        boolean[] inqueue = new boolean[graph.getV()];
        int[] prev = new int[graph.getV()];

        while (!heap.isEmpty()) {
            Vertex minVertext = heap.pop();
            for (WeightedGraphA.Edge edge : graph.getAdj()[minVertext.id]) {
                Vertex nextVertext = vertices[edge.endId];
                if (minVertext.dist + edge.weight < nextVertext.dist) {
                    nextVertext.dist = minVertext.dist + edge.weight ;
                    nextVertext.f = nextVertext.dist + mahantanDist(nextVertext, vertices[d]);
                    prev[nextVertext.id] = minVertext.id;
                    if (inqueue[nextVertext.id]) {
                        heap.update(nextVertext);
                    } else {
                        heap.insert(nextVertext);
                        inqueue[nextVertext.id] = true;
                    }
                }
                if (nextVertext.id == d) {
                    return getSteps(s, d, prev, steps);
                }
            }
        }
        return Collections.emptyList();
    }

    private List<Integer> getSteps(int src, int dest, int[] prev, List<Integer> steps) {
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

    public int mahantanDist(Vertex a, Vertex b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    public static void main(String[] args) {
        List<WeightedGraphA.Edge>[] edges = new LinkedList[4];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new LinkedList<>();
        }

        int[][] pos = new int[4][2];
        pos[0][0] = 0;
        pos[0][1] = 0;
        pos[1][0] = 0;
        pos[1][1] = 0;
        pos[2][0] = 0;
        pos[2][1] = 0;
        pos[3][0] = 0;
        pos[3][1] = 0;
        Astar astar = new Astar(4, pos);
        astar.graph.addEdge(0, 1, 1);
        astar.graph.addEdge(0, 2, 7);
        astar.graph.addEdge(1, 2, 5);
        astar.graph.addEdge(2, 3, 1);

        System.out.println(astar.astar(0, 3));
    }
}
