package leetcode.graphs.printadjacencylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintAdjacencyList {

    public List<List<Integer>> printGraph(int V, int edges[][]) {
        if (edges.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> adjacencyList = new ArrayList<>(edges.length);

        for (int[] edge : edges) {
            addInListForBothNodes(adjacencyList, edge);
        }
        return adjacencyList;
    }

    private void addInListForBothNodes(List<List<Integer>> adjacencyList, int[] edge) {
        addInList(adjacencyList, edge, 0, 1);
        addInList(adjacencyList, edge, 1, 0);
    }

    private void addInList(List<List<Integer>> adjacencyList, int[] edge, int startEdge, int endEdge) {
        while (adjacencyList.size() == 0 || (adjacencyList.size() <= edge[startEdge])) {
            adjacencyList.add(new ArrayList<>());
        }
        adjacencyList.get(edge[startEdge]).add(edge[endEdge]);
    }

    public static void main(String[] args) {

        PrintAdjacencyList printAdjacencyList = new PrintAdjacencyList();
        int V = 5, E = 7;
        int[][] edges = {
                {0, 1},
                {0, 4},
                {4, 1},
                {4, 3},
                {1, 3},
                {1, 2},
                {3, 2}
        };


        System.out.println(printAdjacencyList.printGraph(V, edges));
    }
}
