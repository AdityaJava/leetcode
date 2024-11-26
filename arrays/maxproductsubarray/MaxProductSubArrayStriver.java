package leetcode.arrays.maxproductsubarray;

public class MaxProductSubArrayStriver {

    private int getMaxProduct(int[] nums) {
        int prefix = 1, suffix = 1;
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;
            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length - 1 - i];
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }
        return maxProduct;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 3, -2, 4};
//        int[] nums = {-2, 0, -1};
//        int[] nums = {3, -1, 4};
//        int[] nums = {0, 2};
//        int[] nums = {-2, 3, -4};
//        int[] nums = {-2};
        int[] nums = {0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0};
        MaxProductSubArrayStriver maxProductSubArrayStriver = new MaxProductSubArrayStriver();
        System.out.println(maxProductSubArrayStriver.getMaxProduct(nums));
    }
}
