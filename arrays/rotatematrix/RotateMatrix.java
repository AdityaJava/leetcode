package leetcode.arrays.rotatematrix;

public class RotateMatrix {

    private void rotateMatrixBy90Degree(int[][] matrix) {
        transposeMatrix(matrix);
        reverseRow(matrix);
    }

    //For Square Matrix
    private void transposeMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n - 1; row++) {
            for (int column = row + 1; column < n; column++) {
                swapTranspose(matrix, row, column);
            }
        }
    }

    private void reverseRow(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int start = 0, end = matrix.length - 1;
            while (start < end) {
                swap(matrix, row, start, row, end);
                start++;
                end--;
            }
        }
    }

    private void swap(int[][] matrix, int row1, int column1, int row2, int column2) {
        int temp = matrix[row1][column1];
        matrix[row1][column1] = matrix[row2][column2];
        matrix[row2][column2] = temp;
    }

    private void printMatrix(int[][] matrix) {
        int row = 0, column = 0;
        for (row = 0; row < matrix.length; row++) {
            for (column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

    private void swapTranspose(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
//        System.out.println("After swap");
//        printMatrix(matrix);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        RotateMatrix rotateMatrix = new RotateMatrix();
        rotateMatrix.printMatrix(matrix);
//        rotateMatrix.transposeMatrix(matrix);
//        System.out.println("After transpose");
//        rotateMatrix.printMatrix(matrix);
//        rotateMatrix.reverseRow(matrix);
//        System.out.println("After reversing rows");
//        rotateMatrix.printMatrix(matrix);
        rotateMatrix.rotateMatrixBy90Degree(matrix);
        System.out.println("After rotating matrix by 90deg");
        rotateMatrix.printMatrix(matrix);

    }
}
