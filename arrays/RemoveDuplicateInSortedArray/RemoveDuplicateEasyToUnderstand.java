package leetcode.arrays.RemoveDuplicateInSortedArray;

import java.util.Arrays;

/**
 * RemoveDuplicateEasyToUnderstand
 */
public class RemoveDuplicateEasyToUnderstand {
  public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[i] != nums[j]) {
        nums[i + 1] = nums[j];
        i++;
      }
    }
    return i + 1;
  }

  public static void main(String[] args) {
    int[] nums = { 0, 0, 1, 1, 2 };
    RemoveDuplicateEasyToUnderstand easyToUnderstand = new RemoveDuplicateEasyToUnderstand();
    int count = easyToUnderstand.removeDuplicates(nums);
    System.out.println(count);
    Arrays.asList(nums).forEach(n -> System.out.println(n));
  }
}
