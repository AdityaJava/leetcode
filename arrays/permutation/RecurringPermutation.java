package leetcode.arrays.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecurringPermutation {

    private List<List<Integer>> getPermutations(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        recurPermutation(0, nums, answers);
        return answers;
    }

    private void recurPermutation(int index, int[] nums, List<List<Integer>> answer) {
        if (index == nums.length) {
            answer.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recurPermutation(index + 1, nums, answer);
            swap(i, index, nums);
        }
    }

    private void swap(int i, int index, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;

    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        RecurringPermutation recurringPermutation = new RecurringPermutation();
        List<List<Integer>> answers = recurringPermutation.getPermutations(nums);

        answers.forEach(answer -> {
                    System.out.print("(");
                    answer.forEach(element -> System.out.print(element + " "));
                    System.out.print(")");
                    System.out.println();
                }
        );

    }
}
