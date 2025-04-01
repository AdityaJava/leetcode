package leetcode.recursionandbacktracking.nqueens;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * NQueens
 */
public class NQueens {

    private void nQueenRecursion(List<List<Character>> board, List<Integer> rowHash, List<Integer> lowerDiagonalHash, List<Integer> upperDiagonalHash, int column, List<List<String>> answers) {
        if (column == board.size()) {
            List<String> temp = new LinkedList<>();
            for (int i = 0; i < board.size(); i++) {
                temp.add(new String(board.get(i).stream().map(String::valueOf).collect(Collectors.joining())));
            }
            answers.add(new ArrayList<>(temp));
            return;
        }

        for (int row = 0; row < board.size(); row++) {
            if (isSafe(rowHash, lowerDiagonalHash, upperDiagonalHash, row, column, board.size())) {
                rowHash.set(row, 1);
                lowerDiagonalHash.set(row + column, 1);
                upperDiagonalHash.set(board.size() - 1 + column - row, 1);
                board.get(row).set(column, 'Q');
                nQueenRecursion(board, rowHash, lowerDiagonalHash, upperDiagonalHash, column + 1, answers);
                board.get(row).set(column, '.');
                //Backtracking
                rowHash.set(row, 0);
                lowerDiagonalHash.set(row + column, 0);
                upperDiagonalHash.set(board.size() - 1 + column - row, 0);
            }
        }

    }

    private boolean isSafe(List<Integer> rowHash, List<Integer> lowerDiagonalHash, List<Integer> upperDiagonalHash, int row, int column, int n) {
        return (rowHash.get(row) == 0 && lowerDiagonalHash.get(row + column) == 0 && upperDiagonalHash.get(n - 1 + column - row) == 0);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<Character>> board = constructBoard(n);
        List<Integer> rowHash = new ArrayList<>();
        List<Integer> lowerDiagonalHash = new ArrayList<>();
        List<Integer> upperDiagonalHash = new ArrayList<>();
        int size = board.size();
        for (int i = 0; i < (2 * size-1); i++) {
            rowHash.add(0);
            lowerDiagonalHash.add(0);
            upperDiagonalHash.add(0);
        }

        List<List<String>> answers = new LinkedList<>();
        nQueenRecursion(board, rowHash, lowerDiagonalHash, upperDiagonalHash, 0, answers);
        return answers;
    }

    private List<List<Character>> constructBoard(int n) {
        List<List<Character>> board = new ArrayList<>();
        List<Character> columns;
        for (int i = 0; i < n; i++) {
            columns = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                columns.add('.');
            }
            board.add(columns);
        }
        return board;
    }

    public static void main(String[] args) {
        int n = 4;
        NQueens nQueens = new NQueens();
        nQueens.solveNQueens(n).forEach(eachAnswer -> {
            System.out.println(eachAnswer);
        });
    }
}
