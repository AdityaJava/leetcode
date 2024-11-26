package leetcode.arrays.ReArrangeELementsBySign.notsameinnumber;

import java.util.ArrayList;
import java.util.List;

//This is used for array with positive and negative number which are not same in count

// But This can also be used for positive and negative number which are same in count
public class ReArrangeElementsBySignOptimalForNotSamePosAndNegative {

    private static void reArrange(int[] nums) {
        List<Integer> positiveIntegers = new ArrayList<>();
        List<Integer> negativeIntegers = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negativeIntegers.add(nums[i]);
            } else if (nums[i] > 0) {
                positiveIntegers.add(nums[i]);
            }
        }
        int minLength = positiveIntegers.size() < negativeIntegers.size() ? positiveIntegers.size() : negativeIntegers.size();
        int positiveIntegersPointer = 0, negativeIntegersPointer = 0;
        for (int i = 0; i < minLength; i++) {
            nums[2 * i] = positiveIntegers.get(positiveIntegersPointer);
            nums[(2 * i) + 1] = negativeIntegers.get(negativeIntegersPointer);
            positiveIntegersPointer++;
            negativeIntegersPointer++;
        }

        for (int i = minLength * 2; i < nums.length && positiveIntegers.size() > minLength; i++) {
            nums[i] = positiveIntegers.get(positiveIntegersPointer);
            positiveIntegersPointer++;
        }

        for (int i = minLength * 2; i < nums.length && negativeIntegers.size() > minLength; i++) {
            nums[i] = negativeIntegers.get(negativeIntegersPointer);
            negativeIntegersPointer++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 3, 4, -3, 1};
        ReArrangeElementsBySignOptimalForNotSamePosAndNegative.reArrange(nums);
    }
}
