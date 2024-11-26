package leetcode.arrays.pascaltriangle.guesselement;

public class GuessElementInPascalTriangleOptimal {
    private Long guessElementInPascalTriangleByRowAndColumnOptimal(int rowNumber, int columnNumber) {
        int n = rowNumber - 1;
        int r = columnNumber - 1;
        long result = 1;
        for (int i = 0; i < r; i++) {
            result = result * (n - i);
            result = result / (i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        GuessElementInPascalTriangleOptimal guessElementInPascalTriangleOptimal = new GuessElementInPascalTriangleOptimal();
        long element1 = guessElementInPascalTriangleOptimal.guessElementInPascalTriangleByRowAndColumnOptimal(3, 2);
        System.out.println(element1);

    }
}
