package leetcode.binarysearch.answers.FindTheSmallestDivisorGivenAThreshold;

import java.util.Arrays;
import java.util.List;

public class FindTheSmallestDivisorGivenAThreshold {

    public int smallestDivisor(int[] nums, int threshold) {
        List<Integer> minMax = getMinMax(nums);
        int low = 1;
        int high = minMax.get(1);
        int mid = -1;
        int answer = -1;
        boolean isDivisorPossible = false;
        while (low <= high) {
            mid = (low + high) / 2;
            isDivisorPossible = isDivisorPossible(nums, threshold, mid);
            if (isDivisorPossible) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    private boolean isDivisorPossible(int[] nums, int threshold, double divisor) {
        int count = 0;
        int sum = 0;
        for (double num : nums) {
            sum += Math.ceil(num / divisor);
        }
        if (sum > threshold) {
            return false;
        }
        return true;
    }


    private List<Integer> getMinMax(int[] bloomDays) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int bloomDay : bloomDays) {
            if (bloomDay > max) {
                max = bloomDay;
            }
            if (bloomDay < min) {
                min = bloomDay;
            }
        }
        return Arrays.asList(min, max);
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 5, 9};
//        int threshold = 6;

//        int[] nums = {44, 22, 33, 11, 1};
//        int threshold = 5;

        int[] nums = {21212, 10101, 12121};
        int threshold = 1000000;
        //expected answer=1


        FindTheSmallestDivisorGivenAThreshold findTheSmallestDivisorGivenAThreshold = new FindTheSmallestDivisorGivenAThreshold();
        System.out.println(findTheSmallestDivisorGivenAThreshold.smallestDivisor(nums, threshold));
    }
}
