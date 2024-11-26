package leetcode.arrays.singlenumber;
//https://leetcode.com/problems/single-number/description/

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.
 */

// Hint: XOR with same element is 0 and XOR with 0 of element is that element itself
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = nums[i] ^ xor;
        }
        return xor;
    }


    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(SingleNumber.singleNumber(nums));
    }
}
