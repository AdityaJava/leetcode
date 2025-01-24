package leetcode.arrays.threesum.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ThreeSumOptimalPractice1
 */
public class ThreeSumOptimalPractice1 {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i != 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum < 0) {
          do {
            j++;
          }
          while (j < k && nums[j] == nums[j - 1]);
        }
        else if (sum > 0) {
          do {
            k--;
          }
          while (j < k && nums[k] == nums[k + 1]);
        }
        else {
          result.add(Arrays.asList(nums[i], nums[j], nums[k]));
          do {
            j++;
          }
          while (j < k && nums[j] == nums[j - 1]);
          do {
            k--;
          }
          while (j < k && nums[k] == nums[k + 1]);
        }
      }

    }
    return result;
  }

  public static void main(String[] args) {
    //    int[] nums = { -1, 0, 1, 2, -1, -4 };
    int[] nums = { -2, -2, -2, -1, -1, -1, 0, 0, 0, 2, 2, 2, 2 };
    ThreeSumOptimalPractice1 threeSumOptimalPractice1 = new ThreeSumOptimalPractice1();
    threeSumOptimalPractice1.threeSum(nums).forEach(list -> System.out.println(list));
  }
}
