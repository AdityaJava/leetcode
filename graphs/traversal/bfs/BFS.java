package leetcode.graphs.traversal.bfs;

import leetcode.graphs.createadjacencylist.AdjacencyListCreator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BFS {

    public List<Integer> traverseGraph(List<List<Integer>> adjacencyList, int v, int startingNode) {
        List<Boolean> visited = new ArrayList<>(Collections.nCopies(v, false));
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startingNode);
        visited.add(startingNode, true);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer element = queue.poll();
            result.add(element);
            queue.addAll(getChildrenNotVisited(adjacencyList.get(element), visited));
        }
        return result;
    }

    private List<Integer> getChildrenNotVisited(List<Integer> eachadjacencyList, List<Boolean> visited) {
        List<Integer> childrenNotVisited = new ArrayList<>();
        for (Integer child : eachadjacencyList) {
            if (!visited.get(child)) {
                childrenNotVisited.add(child);
                visited.set(child, true);
            }
        }
        return childrenNotVisited;
    }

    public static void main(String[] args) {
//        int[][] edges = {
//                {0, 1},
//                {0, 2},
//                {0, 3},
//                {1, 4},
//                {1, 5},
//                {2, 6},
//                {2, 7},
//                {3, 8},
//                {3, 9},
//                {4, 10},
//                {5, 10},
//                {6, 11},
//                {7, 11},
//                {8, 12},
//                {9, 13},
//                {10, 14},
//                {11, 14},
//                {12, 15},
//                {13, 15},
//                {14, 16},
//                {15, 16}
//        };
//        int v = 17; // Number of vertices
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
        BFS bfs = new BFS();
        System.out.println(bfs.traverseGraph(adjacencyList, v, startingNode));
    }
}
