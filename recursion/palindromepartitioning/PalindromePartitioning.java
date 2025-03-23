package leetcode.recursion.palindromepartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * PalindromePartitioning
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partitionRecursively(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void partitionRecursively(String s, int index, List<String> partition, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(partition));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s.substring(index, i + 1))) {
                partition.add(s.substring(index, i + 1));
                partitionRecursively(s, i + 1, partition, res);
                partition.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabb";
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        for (List<String> stringList : palindromePartitioning.partition(s)) {
            System.out.println(stringList);
        }
    }
}
