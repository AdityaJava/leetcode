package leetcode.learnthebasics.learnbasicrecursion;

public class FibonacciSeries {

    private int getFibonacciTill(int n, int fibonacci) {
        if (n == 0) {
            return 0;
        } else if (n == 2 || n == 1) {
            return 1;
        } else {
            fibonacci = getFibonacciTill(n - 1, fibonacci);
            fibonacci += getFibonacciTill(n - 2, fibonacci);
            return fibonacci;
        }
    }

    public static void main(String[] args) {
        FibonacciSeries fibonacciSeries = new FibonacciSeries();
        System.out.println(fibonacciSeries.getFibonacciTill(5, 0));
    }
}
