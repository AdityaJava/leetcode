package leetcode.graphs.numberofprovinces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfProvinces {

    public List<List<Integer>> createAdjacencyList(int edges[][]) {
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

    private int getNumberOfProvinces(List<List<Integer>> adjacencyList) {
        List<Boolean> isVisitedList = new ArrayList<>(Collections.nCopies(adjacencyList.size(), false));
        int numberOfProvinces = 0;
        for (int i = 0; i < isVisitedList.size(); i++) {
            if (!isVisitedList.get(i)) {
                numberOfProvinces++;
                dfs(adjacencyList, isVisitedList, i);
            }
        }
        return numberOfProvinces;
    }

    private void dfs(List<List<Integer>> adjacencyList, List<Boolean> isVisitedList, Integer startNode) {
        isVisitedList.set(startNode, true);
        for (Integer i : adjacencyList.get(startNode)) {
            if (!isVisitedList.get(i)) {
                dfs(adjacencyList, isVisitedList, i);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjacencyList = createAdjacencyList(isConnected);
        return getNumberOfProvinces(adjacencyList);
    }

    public static void main(String[] args) {
        NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(numberOfProvinces.findCircleNum(isConnected));
    }

}
