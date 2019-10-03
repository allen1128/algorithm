package com.xl.algo.deepdive.graph;

public class WeightedGraph {
    public int[][] adjacentMatrix;

    public WeightedGraph(int x, int y) {
        adjacentMatrix = new int[x][y];
    }

    public void insert(int i, int j, int weight) {
        adjacentMatrix[i][j] = weight;
    }
}
