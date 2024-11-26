package leetcode.arrays.majorityelementbymooresvotingalgorithm;

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
  Link: https://leetcode.com/problems/majority-element/description/

  video Link: https://www.youtube.com/watch?v=nP_ns3uSh80
 */

import java.util.HashMap;
import java.util.Map;

public class BetterSolution {

    private static int findMajorityElement(int[] nums) {
        Map<Integer, Integer> visitedElements = new HashMap<>();
        int timesToCount = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            Integer visitedElementCount = visitedElements.get(nums[i]);
            if (visitedElementCount == null) {
                visitedElementCount = 1;
                visitedElements.put(nums[i], visitedElementCount);
            } else {
                visitedElementCount++;
                visitedElements.put(nums[i], visitedElementCount);
            }
            if (visitedElementCount > timesToCount) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int[] nums1 = {3, 1, 3, 3, 2};
        int[] nums2 = {1};
        System.out.println(BetterSolution.findMajorityElement(nums2));
    }
}
