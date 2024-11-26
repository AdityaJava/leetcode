package leetcode.arrays.maxproductsubarray;

public class MaxProductSubArray {
    public int maxProduct(int[] nums) {
        int product = 0;
        int maxProduct = 0;
        boolean first = true;
        for (int i = 0; i < nums.length; i++) {
            product = product >= 0 ? product * nums[i] : nums[i];
            if (first) {
                maxProduct = product;
                first = false;
            } else if (maxProduct <= product) {
                maxProduct = product;
                product = 0;
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 3, -2, 4};
//        int[] nums = {-2, 0, -1};
        int[] nums = {3, -1, 4};
//        int[] nums = {-2};
        MaxProductSubArray maxProductSubArray = new MaxProductSubArray();
        System.out.println(maxProductSubArray.maxProduct(nums));
    }
}
