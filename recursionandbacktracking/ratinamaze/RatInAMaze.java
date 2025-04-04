package leetcode.recursionandbacktracking.ratinamaze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * RatInAMaze
 */
public class RatInAMaze {

    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        String directions = "DLRU";//Sorted lexicographically;

        // The rowDirection and columnDirection are stored in such a way like that it will first go in down, left, right, up
        List<Integer> rowDirection = Arrays.asList(1, 0, 0, -1);
        List<Integer> columnDirection = Arrays.asList(0, -1, 1, 0);
        ArrayList<String> answers = new ArrayList<>();
        List<List<Integer>> visited = new ArrayList<>();
        initialize(visited, mat.size());
        findPathRecursively(mat, directions, rowDirection, columnDirection, visited, 0, 0, answers, new String());
        return answers;
    }

    private void initialize(List<List<Integer>> visited, int rowSize) {
        for (int row = 0; row < rowSize; row++) {
            ArrayList<Integer> inner = new ArrayList<>();
            for (int column = 0; column < rowSize; column++) {
                inner.add(0);
            }
            visited.add(inner);
        }
    }

    private void findPathRecursively(ArrayList<ArrayList<Integer>> mat, String directions, List<Integer> rowDirection, List<Integer> columnDirection, List<List<Integer>> visited, int row, int column,
        ArrayList<String> answers, String answer) {
        if (row == mat.size() - 1 && column == mat.size() - 1) {
            answers.add(answer);
            return;
        }

        for (int direction = 0; direction < 4; direction++) {
            int nextRow = row + rowDirection.get(direction);
            int nextColumn = column + columnDirection.get(direction);
            if (isPossibleForDirection(visited, nextRow, nextColumn, mat)) {
                visited.get(row).set(column, 1);
                answer = answer + directions.charAt(direction);
                findPathRecursively(mat, directions, rowDirection, columnDirection, visited, nextRow, nextColumn, answers, answer);
                answer = answer.substring(0, answer.length() - 1 < 0 ? 0 : answer.length() - 1);
                visited.get(row).set(column, 0);
            }
        }
    }

    private boolean isPossibleForDirection(List<List<Integer>> visited, int row, int column, ArrayList<ArrayList<Integer>> mat) {
        return (row >= 0 && row < mat.size() && column >= 0 && column < mat.size() && visited.get(row).get(column) == 0 && mat.get(row).get(column) == 1);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>(
            Arrays.asList(new ArrayList<>(Arrays.asList(1, 0, 0, 0)), new ArrayList<>(Arrays.asList(1, 1, 0, 1)), new ArrayList<>(Arrays.asList(1, 1, 0, 0)),
                new ArrayList<>(Arrays.asList(0, 1, 1, 1))));
        RatInAMaze ratInAMaze = new RatInAMaze();
        ratInAMaze.findPath(mat).forEach(answer -> System.out.println(answer));
    }
}
