package leetcode.learnthebasics.learnbasicrecursion;

public class SumOfNTerms {
    private long sumOfNTerms(long n, long sum) {
        if (n == 1) {
            return 1;
        } else {
            sum = sumOfNTerms(n - 1, sum);
            sum += Double.valueOf(Math.pow(n, 3)).longValue();
            return sum;
        }
    }

    public static void main(String[] args) {
        SumOfNTerms sumOfNTerms = new SumOfNTerms();
        System.out.println(sumOfNTerms.sumOfNTerms(5, 0));
    }
}
