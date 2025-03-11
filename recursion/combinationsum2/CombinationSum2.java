package leetcode.recursion.combinationsum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import leetcode.recursion.combinationsum1.CombinationSum;

/**
 * CombinationSum2
 */
public class CombinationSum2 {

  private void recursionCombination(int index, int target, List<Integer> dataStructure, int[] candidates, List<List<Integer>> answers) {
    if (target == 0) {
      answers.add(new ArrayList<>(dataStructure));
      return;
    }
    for (int i = index; i < candidates.length; i++) {
      if (i > index && candidates[i] == candidates[i - 1]) {
        continue;
      }
      if (target < candidates[i]) {
        break;
      }
      dataStructure.add(candidates[i]);
      recursionCombination(i + 1, target - candidates[i], dataStructure, candidates, answers);
      dataStructure.removeLast();
    }
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> answers = new ArrayList<>();
    Arrays.sort(candidates);
    recursionCombination(0, target, new ArrayList<>(), candidates, answers);
    return answers;
  }

  public static void main(String[] args) {
    int[] candidates =
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
    int target = 30;
    CombinationSum2 combinationSum2 = new CombinationSum2();
    combinationSum2.combinationSum2(candidates, target).forEach(System.out::println);
  }
}
