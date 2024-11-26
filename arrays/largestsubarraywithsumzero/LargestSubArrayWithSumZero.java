package leetcode.arrays.largestsubarraywithsumzero;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithSumZero {

    private int findLargestSubArrayWithSumZero(int[] arr) {
        int sum = 0;
        int startPosition;
        int endPosition;
        int largestLength = 0;
        int length = 0;
        Map<Integer, Integer> sumToPosition = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                largestLength = i + 1;
            } else {
                if (sumToPosition.containsKey(sum)) {
                    largestLength = Math.max(largestLength, i - sumToPosition.get(sum));
                } else {
                    sumToPosition.put(sum, i);
                }
            }
        }
        return largestLength;
    }

    public static void main(String[] args) {
        // int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int[] arr = {-1, 1, -1, 1};
        LargestSubArrayWithSumZero largestSubArrayWithSumZero = new LargestSubArrayWithSumZero();
        System.out.println(largestSubArrayWithSumZero.findLargestSubArrayWithSumZero(arr));
    }
}
