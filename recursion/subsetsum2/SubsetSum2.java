package leetcode.recursion.subsetsum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SubsetSum2
 */
public class SubsetSum2 {

  private void subsetSum(int index, int[] nums, List<List<Integer>> answerList, List<Integer> dataStructure) {
    answerList.add(new ArrayList<>(dataStructure));
    for (int i = index; i < nums.length; i++) {
      if (i != index && nums[i] == nums[i - 1]) {
        continue;
      }
      dataStructure.add(nums[i]);
      subsetSum(i + 1, nums, answerList, dataStructure);
      dataStructure.remove(dataStructure.size() - 1);
    }
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> answerList = new ArrayList<>();
    List<Integer> dataStructure = new ArrayList<>();
    int index = 0;
    subsetSum(index, nums, answerList, dataStructure);
    return answerList;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 2 };
    SubsetSum2 subsetSum2 = new SubsetSum2();
    subsetSum2.subsetsWithDup(nums).forEach(integers -> System.out.println(integers));
  }
}
