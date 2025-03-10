package leetcode.recursion.combinationsum1;

import java.util.ArrayList;
import java.util.List;

/**
 * CombinationSum
 */
public class CombinationSum {
  private void recursiveCombinations(int index, int target, int[] candidates, List<Integer> dataStructure, List<List<Integer>> answers) {
    if (index == (candidates.length)) {
      if (target == 0) {
        answers.add(new ArrayList<>(dataStructure));
      }
      return;
    }
    if (target >= candidates[index]) {
      dataStructure.add(candidates[index]);
      recursiveCombinations(index, target - candidates[index], candidates, dataStructure, answers);
      dataStructure.remove(dataStructure.size() - 1);
    }
    recursiveCombinations(index + 1, target, candidates, dataStructure, answers);
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> answers = new ArrayList<>();
    recursiveCombinations(0, target, candidates, new ArrayList<>(), answers);
    return answers;
  }

  public static void main(String[] args) {
    int arr[] = { 2, 3, 6, 7 };
    int target = 7;
    CombinationSum combinationSum = new CombinationSum();
    combinationSum.combinationSum(arr, target).forEach(System.out::println);
  }
}
