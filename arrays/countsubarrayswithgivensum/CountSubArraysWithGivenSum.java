package leetcode.arrays.countsubarrayswithgivensum;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraysWithGivenSum {

    private int getSubArraysWithGivenSum(int[] nums, int k) {
        int count = 0, prefixSum = 0;
        Integer prefixCount = 0;
        Map<Integer, Integer> prefixSumToCount = new HashMap<>();
        prefixSumToCount.put(0, 1);
        int difference = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum = prefixSum + nums[i];
            difference = prefixSum - k;
            prefixCount = prefixSumToCount.get(difference);
            if (prefixCount != null) {
                count += prefixCount;
            }
            prefixCount = prefixSumToCount.get(prefixSum);
            if (prefixCount == null) {
                prefixSumToCount.put(prefixSum, 1);
            } else {
                prefixSumToCount.put(prefixSum, prefixCount + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        CountSubArraysWithGivenSum countSubArraysWithGivenSum = new CountSubArraysWithGivenSum();
        int count = countSubArraysWithGivenSum.getSubArraysWithGivenSum(nums, 3);
        System.out.println(count);
    }
}
