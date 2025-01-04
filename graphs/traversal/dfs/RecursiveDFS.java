package leetcode.graphs.traversal.dfs;

import leetcode.graphs.createadjacencylist.AdjacencyListCreator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecursiveDFS {
    public static List<Integer> getDFSRecursively(List<List<Integer>> adjacencyList, int startNode, List<Boolean> isVisited, List<Integer> answer) {
        isVisited.set(startNode, true);
        answer.add(startNode);
        List<Integer> adjacency = adjacencyList.get(startNode);
        for (Integer i : adjacency) {
            if (!isVisited.get(i)) {
                getDFSRecursively(adjacencyList, i, isVisited, answer);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {0, 4},
                {4, 1},
                {4, 3},
                {1, 3},
                {1, 2},
                {3, 2}
        };
        int v = 5; // Number of vertices
        int startingNode = 0;

        AdjacencyListCreator adjacencyListCreator = new AdjacencyListCreator();
        List<List<Integer>> adjacencyList = adjacencyListCreator.createAdjacencyList(edges);
        List<Boolean> isVisited = new ArrayList<>(Collections.nCopies(v, false));
        List<Integer> answer = new ArrayList<>();
        System.out.println(getDFSRecursively(adjacencyList, startingNode, isVisited, answer));
    }
}

