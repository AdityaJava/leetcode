package leetcode.arrays.RemoveDuplicateInSortedArray;

/**
 * RemoveDuplicates
 */
public class RemoveDuplicates {
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
    //    int[] nums = { 0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
    int[] nums = { 0, 0, 1, 1, 2 };
    RemoveDuplicates removeDuplicates = new RemoveDuplicates();
    int count = removeDuplicates.removeDuplicates(nums);
    System.out.println(count);
    System.out.println(nums);
  }
}
