package leetcode.arrays.kadanealgorithm;

//Kadane's algorithm specifically focuses on finding the maximum sum
// subarray by keeping track of the current subarray's sum and resetting it
// whenever a negative sum is encountered. It's designed for solving the maximum subarray problem.
public class MaximumSubarray {

    //This is known as kadane's algorithm
    private int findMaximumSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (maxSum < sum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }


    public static void main(String[] args) {
        //int[] nums = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.findMaximumSubArray(nums));
    }

}
