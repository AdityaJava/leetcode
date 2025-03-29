package leetcode.recursion.permutations.approach2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PermutationsUsingSwapping
 */
public class PermutationsUsingSwapping {
    private void recursivePermute(int index, int[] nums, List<List<Integer>> answers) {
        if (index == nums.length) {
            answers.add(new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList())));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            recursivePermute(index + 1, nums, answers);
            swap(nums, i, index);
        }
    }

    public static void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        recursivePermute(0, nums, answers);
        return answers;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        PermutationsUsingSwapping permutationsUsingSwapping = new PermutationsUsingSwapping();
        permutationsUsingSwapping.permute(nums).forEach(eachList -> System.out.println(eachList));
    }
}
