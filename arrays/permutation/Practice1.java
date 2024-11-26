package leetcode.arrays.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice1 {

    private List<List<Integer>> createPermutation(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        recurringPermutation(0, nums, answers);
        return answers;
    }

    private void recurringPermutation(int index, int[] nums, List<List<Integer>> answers) {

        if (index == nums.length) {
            answers.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(index, i, nums);
            recurringPermutation(index + 1, nums, answers);
            swap(index, i, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Practice1 practice1 = new Practice1();
        List<List<Integer>> answers = practice1.createPermutation(nums);
        System.out.println(answers);
    }
}
