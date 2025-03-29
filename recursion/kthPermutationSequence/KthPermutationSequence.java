package leetcode.recursion.kthPermutationSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * KthPermutationSequence
 */
public class KthPermutationSequence {

    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int factorial = 1;
        for (int i = 1; i < n; i++) {
            numbers.add(i);
            factorial = factorial * i;
        }
        numbers.add(n);
        k = k - 1;
        String answer = "";
        while (true) {
            answer = answer + numbers.get(k / factorial);
            numbers.remove(k / factorial);
            if (numbers.size() == 0) {
                break;
            }
            k = k % factorial;
            factorial = factorial / numbers.size();
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 3, k = 3;
        KthPermutationSequence kthPermutationSequence = new KthPermutationSequence();
        System.out.println(kthPermutationSequence.getPermutation(n, k));
    }
}
