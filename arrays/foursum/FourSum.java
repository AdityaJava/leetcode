package leetcode.arrays.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FourSum {

    private List<List<Integer>> fourSum(int[] nums, int target) {
        List<Integer> sortedNums = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        List<List<Integer>> answers = new ArrayList<>();
        int length = sortedNums.size();
        int i = 0, j = 0, k = 0, l = 0;
        int sum = 0;
        for (i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (j = i + 1; j < length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                k = j + 1;
                l = length - 1;
                while (k < l) {
                    sum = sortedNums.get(i) + sortedNums.get(j) + sortedNums.get(k) + sortedNums.get(l);
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        answers.add(Arrays.asList(sortedNums.get(i), sortedNums.get(j), sortedNums.get(k), sortedNums.get(l)));
                        k++;
                        l--;
                        while (k < l && sortedNums.get(k) == sortedNums.get(k - 1)) k++;
                        while (k < l && sortedNums.get(l) == sortedNums.get(l + 1)) l--;
                    }
                }
            }
        }
        return answers;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        FourSum fourSum = new FourSum();
        List<List<Integer>> answers = fourSum.fourSum(nums, 0);
        System.out.println(answers);
    }
}
