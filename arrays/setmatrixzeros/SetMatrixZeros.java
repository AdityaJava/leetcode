package leetcode.arrays.setmatrixzeros;

public class SetMatrixZeros {

    private void setMatrixZeros(int[][] matrix) {
        int row = 0, column = 0;
        int column0 = 1;

        //Step1: Traverse over matrix and mark the row and column headers as zero if the element is zero
        for (row = 0; row < matrix.length; row++) {
            for (column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 0) {

                    matrix[row][0] = 0;

                    if (column != 0) {
                        matrix[0][column] = 0;
                    } else {
                        column0 = 0;
                    }
                }
            }
        }

        //Step2: Traverse through matrix ignoring the headers and mark the element as zero if it's row header is zero
        //       or if it's column header is zero
        for (row = 1; row < matrix.length; row++) {
            for (column = 1; column < matrix[row].length; column++) {
                if (matrix[0][column] == 0 || matrix[row][0] == 0) {
                    matrix[row][column] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (column = 0; column < matrix[0].length; column++) {
                matrix[0][column] = 0;
            }
        }

        if (column0 == 0) {
            for (row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
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

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        SetMatrixZeros setMatrixZeros = new SetMatrixZeros();
        setMatrixZeros.printMatrix(matrix);
        setMatrixZeros.setMatrixZeros(matrix);
        System.out.println("After zeros");
        setMatrixZeros.printMatrix(matrix);
    }
}
