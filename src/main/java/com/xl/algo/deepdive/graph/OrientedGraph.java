package com.xl.algo.deepdive.graph;

import com.xl.algo.deepdive.LinkedNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OrientedGraph {
    private int v;
    private int[][] adjacentMatrix;
    private LinkedNode<Integer>[] adjacentTable;
    private boolean useMatrix;

    public OrientedGraph(int vertextSize, boolean useMatrix) {
        this.v = vertextSize;
        this.useMatrix = useMatrix;
        if (useMatrix) {
            adjacentMatrix = new int[vertextSize][vertextSize];
        } else {
            adjacentTable = new LinkedNode[vertextSize];
        }
    }

    public List<Integer> getSteps(int[] prev, int src, int dest, List<Integer> steps) {
        if (src == dest) {
            steps.add(0, dest);
            return steps;
        } else if (prev[dest] != -1) {
            steps.add(0, dest);
            return getSteps(prev, src, prev[dest], steps);
        } else {
            return Collections.emptyList();
        }
    }

    public List<Integer> bfs(int src, int dest) {
        List<Integer> steps = new ArrayList<>();
        if (src == dest) {
            return steps;
        }

        int[] prev = new int[v];
        boolean[] visited = new boolean[v];

        Arrays.fill(prev, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer vertex = queue.poll();
                for (int q : getNeighbors(vertex)) {
                    if (!visited[q]) {
                        prev[q] = vertex;
                        if (q == dest) {
                            getSteps(prev, src, dest, steps);
                            return steps;
                        } else {
                            queue.offer(q);
                            visited[q] = true;
                        }
                    }
                }
            }
        }
        return Collections.emptyList();
    }

    public List<Integer> dfs(int src, int dest) {
        List<Integer> steps = new ArrayList<>();
        if (src == dest) {
            return steps;
        }

        int[] prev = new int[v];
        boolean[] visited = new boolean[v];

        Arrays.fill(prev, -1);
        doDfs(src, dest, prev, visited);
        return getSteps(prev, src, dest, steps);
    }

    private boolean found = false;

    private void doDfs(int src, int dest, int[] prev, boolean[] visited) {
        if (src == dest) {
            found = true;
            return;
        }
        visited[src] = true;
        for (Integer n : getNeighbors(src)) {
            if (!visited[n]) {
                prev[n] = src;
                doDfs(n, dest, prev, visited);
            }
        }
    }


    public void addEdge(int i, int j) {
        if (useMatrix) {
            adjacentMatrix[i][j] = 1;
        } else {
            if (adjacentTable[i] == null) {
                adjacentTable[i] = new LinkedNode(j);
            } else {
                adjacentTable[i].add(new LinkedNode(j));
            }
        }
    }

    public boolean hasEdge(int i, int j) {
        if (useMatrix) {
            return adjacentMatrix[i][j] == 1;
        } else {
            if (adjacentTable[i] == null) {
                return false;
            } else {
                LinkedNode node = adjacentTable[i];
                while (node != null) {
                    if (node.getValue().equals(j)) {
                        return true;
                    }
                    node = node.getNext();
                }
                return false;
            }
        }
    }

    public List<Integer> getNeighbors(int vertex) {
        List<Integer> neighbors = new ArrayList<>();

        if (useMatrix) {
            for (int i = 0; i < adjacentMatrix[vertex].length; i++) {
                if (adjacentMatrix[vertex][i] == 1) {
                    neighbors.add(i);
                }
            }
        } else {
            LinkedNode node = adjacentTable[vertex];
            while (node != null) {
                neighbors.add((Integer) node.getValue());
                node = node.getNext();
            }
        }

        return neighbors;
    }

    public void removeEdge(int i, int j) {
        if (useMatrix) {
            adjacentMatrix[i][j] = 1 ;
        } else {
            if (adjacentTable[i] == null) {
                return;
            } else {
                LinkedNode node = adjacentTable[i];
                if (node.getValue().equals(j)) {
                    adjacentTable[i] = node.getNext();
                }

                LinkedNode prev = null;
                while (node != null) {
                    if (node.getValue().equals(j)) {
                        prev.setNext(node.getNext());
                    }
                    prev = node;
                    node = node.getNext();
                }
            }
        }
    }

    public int getSize() {
        return v;
    }

    public static void main(String[] args) {
        OrientedGraph og = new OrientedGraph(5, false);
        og.addEdge(0, 1);
        og.addEdge(2,1);
        og.addEdge(2,3);
        og.addEdge(3,4);

        System.out.println(og.bfs(2, 4));
    }
}
