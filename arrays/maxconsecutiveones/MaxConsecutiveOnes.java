package leetcode.arrays.maxconsecutiveones;

//https://leetcode.com/problems/max-consecutive-ones/

public class MaxConsecutiveOnes {

  public static int findMaxConsecutiveOnes(int[] nums) {
    int count = 0;
    int maxCount = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        count++;
      }
      else {
        maxCount = maxCount < count ? count : maxCount;
        count = 0;
      }
    }
    maxCount = maxCount < count ? count : maxCount;
    return maxCount;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 1, 0, 1, 1, 1 };
    System.out.println(MaxConsecutiveOnes.findMaxConsecutiveOnes(nums));
  }
}
