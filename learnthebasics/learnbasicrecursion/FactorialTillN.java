package leetcode.learnthebasics.learnbasicrecursion;

import java.util.ArrayList;

public class FactorialTillN {

    static ArrayList<Long> factorialNumbers(long n) {
        ArrayList<Long> factorials = new ArrayList<>();
        factorialTillN(n-1, 1, factorials);
        return factorials;
    }

    private static long factorialTillN(long n, long factorial, ArrayList<Long> results) {
        if (n == 1) {
            factorial = 1;
            results.add(factorial);
            return factorial;
        } else {
            factorial = n * factorialTillN(n - 1, factorial, results);
            results.add(factorial);
            return factorial;
        }
    }

    public static void main(String[] args) {
        FactorialTillN factorialTillN = new FactorialTillN();
//        factorialTillN.factorialTillN(5, 1, new ArrayList<>());
        FactorialTillN.factorialNumbers(5).forEach(e -> System.out.println(e));
    }
}
