package leetcode.arrays.pascaltriangle.createpascaltriangle;

import java.util.ArrayList;
import java.util.List;

public class CreatePascalTriangle {

    private List<List<Integer>> createPascalTriangleTillRow(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        pascalTriangle.add(temp);
        for (int row = 1; row < numRows; row++) {
            pascalTriangle.add(createRow(row + 1));
        }
        return pascalTriangle;
    }

    private List<Integer> createRow(int row) {
        List<Integer> pascalRow = new ArrayList<>();
        int answer = 1;
        pascalRow.add(1);
        for (int column = 1; column < row; column++) {
            answer = answer * (row - column) / column;
            pascalRow.add(answer);
        }
        return pascalRow;
    }

    public static void main(String[] args) {
        CreatePascalTriangle createPascalTriangle = new CreatePascalTriangle();
        List<List<Integer>> pascalTriangle = createPascalTriangle.createPascalTriangleTillRow(5);

        pascalTriangle.forEach(pascalRows -> {
            pascalRows.forEach(element -> {
                System.out.print(element + " ");
            });
            System.out.println();
        });

    }
}
