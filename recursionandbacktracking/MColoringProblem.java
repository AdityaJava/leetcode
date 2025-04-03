package leetcode.recursionandbacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MColoringProblem
 */
public class MColoringProblem {

    private boolean solveRecursively(int totalVertices, int currentVertex, List<int[]> edges, int m, List<Integer> colors) {
        if (currentVertex == totalVertices) {
            return true;
        }

        for (int color = 0; color < m; color++) {
            if (isPossibleToColor(currentVertex, color, edges, colors)) {
                colors.set(currentVertex, color);
                boolean result = solveRecursively(totalVertices, currentVertex + 1, edges, m, colors);
                if (result) {
                    return true;
                }
                colors.set(currentVertex, null);
            }
        }
        return false;
    }

    private boolean isPossibleToColor(int currentVertex, int currentVertexColor, List<int[]> edges, List<Integer> colors) {
        for (int[] edge : edges) {
            if (edge[0] == currentVertex || edge[1] == currentVertex) {
                int otherVertex = edge[0] == currentVertex ? edge[1] : edge[0];
                if (colors.get(otherVertex) != null && colors.get(otherVertex) == currentVertexColor) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean graphColoring(int v, List<int[]> edges, int m) {
        List<Integer> colors = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            colors.add(null);
        }
        return solveRecursively(v, 0, edges, m, colors);
    }

    public static void main(String[] args) {
        int v = 4, m = 3;
        List<int[]> edges = Arrays.asList(new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 0 }, new int[] { 0, 2 });
        MColoringProblem mColoringProblem = new MColoringProblem();
        System.out.println(mColoringProblem.graphColoring(v, edges, m));
    }
}
