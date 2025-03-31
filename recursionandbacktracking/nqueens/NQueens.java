package leetcode.recursionandbacktracking.nqueens;

import java.util.ArrayList;
import java.util.List;

/**
 * NQueens
 */
public class NQueens {

    private void nQueenRecursion(List<List<Character>> board, List<Integer> rowHash, List<Integer> lowerDiagonalHash, List<Integer> upperDiagonalHash, int column) {

        for (int row = 0; row < board.size(); row++) {
            if (isSafe(rowHash, lowerDiagonalHash, upperDiagonalHash, row, column, board.size())) {
                rowHash.set(row, 1);
                lowerDiagonalHash.set(row + column, 1);
                upperDiagonalHash.set(board.size() - 1 + column + row, 1);
                nQueenRecursion(board, rowHash, lowerDiagonalHash, upperDiagonalHash, column + 1);
                rowHash.set(row, 0);
                lowerDiagonalHash.set(row + column, 0);
                upperDiagonalHash.set(board.size() - 1 + column + row, 0);
            }
        }

    }

    private boolean isSafe(List<Integer> rowHash, List<Integer> lowerDiagonalHash, List<Integer> upperDiagonalHash, int row, int column, int n) {
        if (rowHash.get(row) == 0 && lowerDiagonalHash.get(row + column) == 0 && upperDiagonalHash.get(n - 1 + column - row) == 0) {
            return true;
        }
        return false;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<Character>> board = constructBoard(n);
        List<Integer> rowHash = new ArrayList<>();
        List<Integer> lowerDiagonalHash = new ArrayList<>();
        List<Integer> upperDiagonalHash = new ArrayList<>();
        nQueenRecursion(board, rowHash, lowerDiagonalHash, upperDiagonalHash);
        return null;
    }

    private List<List<Character>> constructBoard(int n) {
        List<List<Character>> board = new ArrayList<>();
        List<Character> columns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                columns.add('.');
            }
            board.add(columns);
        }
        return board;
    }

    public static void main(String[] args) {

    }
}
