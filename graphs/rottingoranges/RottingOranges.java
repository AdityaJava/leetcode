package leetcode.graphs.rottingoranges;

import java.util.LinkedList;
import java.util.Queue;

class RottenOrangePlaceTime {
    int row;
    int column;
    int time;

    public RottenOrangePlaceTime(int row, int column, int time) {
        this.row = row;
        this.column = column;
        this.time = time;
    }
}

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        Queue<RottenOrangePlaceTime> rottenOrangePlaceTimeQueue = new LinkedList<>();
        int freshOrangeCount = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 2) {
                    rottenOrangePlaceTimeQueue.add(new RottenOrangePlaceTime(row, col, 0));
                } else if (grid[row][col] == 1) {
                    freshOrangeCount++;
                }
            }
        }
        int minimumTimeToRottenOranges = 0;
        int rottenOranges = 0;
        while (!rottenOrangePlaceTimeQueue.isEmpty()) {
            int size = rottenOrangePlaceTimeQueue.size();
            rottenOranges += size;
            for (int i = 0; i < size; i++) {
                RottenOrangePlaceTime rottenOrangePlaceTime = rottenOrangePlaceTimeQueue.poll();
                rottenNeighbours(rottenOrangePlaceTime, grid, rottenOrangePlaceTimeQueue);
            }
            if (!rottenOrangePlaceTimeQueue.isEmpty()) {
                minimumTimeToRottenOranges++;
            }
        }
        return rottenOranges == freshOrangeCount ? minimumTimeToRottenOranges : -1;
    }

    private void rottenNeighbours(RottenOrangePlaceTime rottenOrangePlaceTime, int[][] grid, Queue<RottenOrangePlaceTime> queue) {
        int min = 0;
        int max = grid.length - 1;
        int rottenOrangeRow = rottenOrangePlaceTime.row;
        int rottenOrangeColumn = rottenOrangePlaceTime.column;
        int rottenOrangeTime = rottenOrangePlaceTime.time;
        if (rottenOrangeRow - 1 >= 0 && isOrangeFresh(rottenOrangeRow - 1, rottenOrangeColumn, grid)) {
            queue.add(new RottenOrangePlaceTime(rottenOrangeRow - 1, rottenOrangeColumn, rottenOrangeTime + 1));
        }
        if (rottenOrangeRow + 1 <= max && isOrangeFresh(rottenOrangeRow + 1, rottenOrangeColumn, grid)) {
            queue.add(new RottenOrangePlaceTime(rottenOrangeRow + 1, rottenOrangeColumn, rottenOrangeTime + 1));
        }
        if (rottenOrangeColumn - 1 >= 0 && isOrangeFresh(rottenOrangeRow, rottenOrangeColumn - 1, grid)) {
            queue.add(new RottenOrangePlaceTime(rottenOrangeRow, rottenOrangeColumn - 1, rottenOrangeTime + 1));
        }
        if (rottenOrangeColumn + 1 <= max && isOrangeFresh(rottenOrangeRow, rottenOrangeColumn + 1, grid)) {
            queue.add(new RottenOrangePlaceTime(rottenOrangeRow, rottenOrangeColumn + 1, rottenOrangeTime + 1));
        }
    }

    private boolean isOrangeFresh(int rottenOrangeRow, int rottenOrangeColumn, int[][] grid) {
        return (grid[rottenOrangeRow][rottenOrangeColumn] == 1);
    }

}
