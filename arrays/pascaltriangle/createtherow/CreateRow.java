package leetcode.arrays.pascaltriangle.createtherow;

import java.util.ArrayList;
import java.util.List;

public class CreateRow {

    //Formula: ans*(row - col)/col
    private List<Integer> createRowByRowNumber(int rowNumber) {
        List<Integer> pascalTriangleRow = new ArrayList<>();
        pascalTriangleRow.add(1);
        int answer = 1;
        for (int column = 1; column < rowNumber; column++) {
            answer = answer * (rowNumber - column) / column;
            pascalTriangleRow.add(answer);
        }
        return pascalTriangleRow;
    }

    public static void main(String[] args) {
        CreateRow createRow = new CreateRow();
        createRow.createRowByRowNumber(6).forEach(e -> System.out.print(e + " "));
        System.out.println();
        createRow.createRowByRowNumber(7).forEach(e -> System.out.print(e + " "));
    }
}
