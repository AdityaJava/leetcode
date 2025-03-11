package leetcode.recursion.combinationsum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * CombinationSum2
 */
//Brute force because we are using set to
public class BruteForceCombinationSum2 {
  private void recursionCombination(int index, int target, List<Integer> dataStructure, int[] candidates, List<List<Integer>> answers) {
    if (index == candidates.length) {
      if (target == 0) {
        answers.add(new ArrayList<>(dataStructure));
      }
      return;
    }
    if (target >= candidates[index]) {
      dataStructure.add(candidates[index]);
      recursionCombination(index + 1, target - candidates[index], dataStructure, candidates, answers);
      dataStructure.removeLast();
    }
    recursionCombination(index + 1, target, dataStructure, candidates, answers);
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> answers = new ArrayList<>();
    Arrays.sort(candidates);
    recursionCombination(0, target, new ArrayList<>(), candidates, answers);
    //This makes it brute force
    return answers.stream().collect(Collectors.toCollection(LinkedHashSet::new)).stream().collect(Collectors.toList());
  }

  public static void main(String[] args) {
    //    int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
    //    int target = 8;

    int[] candidates =
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
    int target = 30;

    BruteForceCombinationSum2 bruteForceCombinationSum2 = new BruteForceCombinationSum2();
    bruteForceCombinationSum2.combinationSum2(candidates, target).forEach(System.out::println);
  }
}
