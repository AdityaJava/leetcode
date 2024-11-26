package leetcode.arrays.pairWithMaxSum;

public class PairWithMaxSum {

    private static int pairWithMaxSum(int[] nums) {
        int windowSize = 2;
        int windowSum = 0;
        for (int i = 0; i < windowSize; i++) {
            windowSum += nums[i];
        }
        int maxSum = windowSum;
        for (int i = windowSize; i < nums.length; i++) {
            windowSum = windowSum - nums[i - windowSize] + nums[i];
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 1, 5, 6};
        System.out.println(pairWithMaxSum(nums));
    }
}
