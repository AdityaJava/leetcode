package leetcode.recursionandbacktracking.sudoku;

import java.util.Arrays;

/**
 * SudokuSolver
 */
public class SudokuSolver {

    private boolean solveSudokuRecursively(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(c, board, row, column)) {
                            board[row][column] = c;
                            if (solveSudokuRecursively(board)) {
                                return true;
                            }
                            else {
                                board[row][column] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char c, char[][] board, int row, int column) {
        for (int i = 0; i < 9; i++) {
            int gridRow = 3 * (row / 3) + i / 3;
            int gridColumn = 3 * (column / 3) + i % 3;

            if (board[row][i] == c) {
                return false;
            }
            else if (board[i][column] == c) {
                return false;
            }
            else if (board[gridRow][gridColumn] == c) {
                return false;
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solveSudokuRecursively(board);
    }

    public static void main(String[] args) {
        char[][] board = { { '9', '5', '7', '.', '1', '3', '.', '8', '4' }, { '4', '8', '3', '.', '5', '7', '1', '.', '6' }, { '.', '1', '2', '.', '4', '9', '5', '3', '7' },
            { '1', '7', '.', '3', '.', '4', '9', '.', '2' }, { '5', '.', '4', '9', '7', '.', '3', '6', '.' }, { '3', '.', '9', '5', '.', '8', '7', '.', '1' },
            { '8', '4', '5', '7', '9', '.', '6', '1', '3' }, { '.', '9', '1', '.', '3', '6', '.', '7', '5' }, { '7', '.', '6', '1', '8', '5', '4', '.', '9' } };
        SudokuSolver sudokuSolver = new SudokuSolver();

        sudokuSolver.solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }
}
