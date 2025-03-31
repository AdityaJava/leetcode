package leetcode.recursionandbacktracking.permutations.approach1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Permutations
 */
public class Permutations {

    private void recursivePermutation(int[] nums, List<Integer> dataStructure, List<List<Integer>> answers, Map<Integer, Boolean> taken) {
        if (dataStructure.size() == nums.length) {
            answers.add(new ArrayList<>(dataStructure));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (taken.get(nums[i]) == null) {
                taken.put(nums[i], true);
                dataStructure.add(nums[i]);
                recursivePermutation(nums, dataStructure, answers, taken);
                dataStructure.removeLast();
                taken.put(nums[i], null);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        recursivePermutation(nums, new ArrayList<>(), answers, new HashMap<>());
        return answers;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        Permutations permutations = new Permutations();
        permutations.permute(nums).forEach(eachList -> System.out.println(eachList));
    }
}
