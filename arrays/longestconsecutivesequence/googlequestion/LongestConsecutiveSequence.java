package leetcode.arrays.longestconsecutivesequence.googlequestion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*
Problem Statement: You are given an array of ‘N’ integers. You need to find the length of the longest sequence which contains the consecutive elements.

Example 1:
Input:
 [100, 200, 1, 3, 2, 4]

Output:
 4

Explanation:
 The longest consecutive subsequence is 1, 2, 3, and 4.

Input:
 [3, 8, 5, 7, 6]

Output:
 4

Explanation:
 The longest consecutive subsequence is 5, 6, 7, and 8.
 */

//https://www.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1
public class LongestConsecutiveSequence {

    private int findLongestConsecutiveSequence(int[] arr) {
        Set<Integer> elements = new TreeSet<>();
        for (int i : arr) {
            elements.add(i);
        }
        int nextElement;
        int count = 0;
        int maxCount = 0;

        Iterator<Integer> elementIterator = elements.iterator();

        while (elementIterator.hasNext()) {
            Integer element = elementIterator.next();
            if (!elements.contains(element - 1)) {
                count++;
                nextElement = elements.contains(element + 1) ? element + 1 : -1;
                while (elements.contains(nextElement)) {
                    count++;
                    nextElement++;
                    if (elementIterator.hasNext()) {
                        elementIterator.next();
                    }
                }
                if (maxCount < count) {
                    maxCount = count;
                }
                count = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
//        int[] arr = {102, 4, 100, 1, 101, 3, 2, 1, 1};
//        int[] arr = {34, 2, 7, 23, 31, 38, 13, 11, 37, 19, 45, 6};
        int[] arr = {38, 41, 5, 50};
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        System.out.println(longestConsecutiveSequence.findLongestConsecutiveSequence(arr));
    }
}
