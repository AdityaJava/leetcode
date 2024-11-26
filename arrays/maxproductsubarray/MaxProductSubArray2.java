package leetcode.arrays.maxproductsubarray;

public class MaxProductSubArray2 {
    private int maxProductSubArray(int[] nums) {
        int product = 1;
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            product = product > 0 ? product * nums[i] : product * nums[i]>0 ? product * nums[i] : nums[i];
            if (maxProduct < product) {
                maxProduct = product;
            } else {
                product = 1;
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
//        int[] nums  = {2, 3, -2, 4};
//        int[] nums = {-2, 0, -1};
//        int[] nums = {3, -1, 4};
//        int[] nums = {0, 2};
//        int[] nums = {-2, 3, -4};
//        int[] nums = {-2};
        int[] nums = {-3, -1, -1};
        MaxProductSubArray2 maxProductSubArray2 = new MaxProductSubArray2();
        System.out.println(maxProductSubArray2.maxProductSubArray(nums));

    }
}
