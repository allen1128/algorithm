package com.xl.algo.deepdive.graph;

public class UnorientedGraph {
    public int[][] adjacentMatrix;

    public UnorientedGraph(int x, int y) {
        adjacentMatrix = new int[x][y];
    }

    public void insert(int i, int j) {
        adjacentMatrix[i][j] = 1;
        adjacentMatrix[j][i] = 1;
    }
}
