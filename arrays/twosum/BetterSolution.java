package leetcode.arrays.twosum;

//https://leetcode.com/problems/two-sum/description/
//https://www.youtube.com/watch?v=UXDSeD9mN-k
/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

 */


//This is better and also optimal solution for this kind of problem
//But for yes or no question like to tell only if that there are 2 numbers which sums upto the given number there is optimal
//solution

import java.util.HashMap;
import java.util.Map;

public class BetterSolution {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> availableElements = new HashMap<>();
        int neededElement = 0;
        Integer neededElementsIndex = 0;
        int pointer = 1;
        for (int i = 0; i < nums.length; i++) {
            neededElement = target - nums[i];
            neededElementsIndex = availableElements.get(neededElement);
            if (neededElementsIndex == null) {
                availableElements.put(nums[i], i);
            } else {
                return new int[]{neededElementsIndex, i};
            }
        }
        return new int[]{};
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4};
        twoSum(arr, 6);

    }
}
