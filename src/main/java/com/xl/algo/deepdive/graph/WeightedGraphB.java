package com.xl.algo.deepdive.graph;

public class WeightedGraphB {
    private int[][] adjacentMatrix;
    private int v;


    public WeightedGraphB(int v) {
        this.adjacentMatrix = new int[v][v];
        this.v = v;
    }

    public void insert(int i, int j, int weight) {
        adjacentMatrix[i][j] = weight;
    }
}
