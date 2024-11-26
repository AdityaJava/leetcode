package leetcode.binarysearch.onedimenarrays.findfirstandlastpos;

import java.util.Arrays;

public class FindFirstAndLastPositionUsingLowerAndUpperBound {

    private static int findUpperBound(int[] arr, int x) {
        int high = arr.length;
        int low = 0;
        int mid = -1;
        int answer = arr.length;

        mid = (low + high) / 2;
        while (low <= high && mid>=0) {
            mid = (low + high) / 2;

            if (x >= arr[mid]) {
                answer = mid;

                //Look for more greater numbers on right
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

    private static int findLowerBound(int[] arr, int x) {
        int high = arr.length;
        int low = 0;
        int mid = -1;
        int answer = arr.length;

        mid = (low + high) / 2;
        while (low <= high && mid>=0) {
            mid = (low + high) / 2;

            if (x <= arr[mid]) {
                answer = mid;

                //Look for smaller index on left as it is sorted array
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    private static int[] findFirstAndLastPosition(int[] nums, int target) {
        int lowerBound = findLowerBound(nums, target);
        int upperBound = findUpperBound(nums, target);

        if (lowerBound == nums.length || nums[lowerBound] != target) return new int[]{-1, -1};

        return new int[]{lowerBound, upperBound};
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        Arrays.stream(FindFirstAndLastPositionUsingLowerAndUpperBound.findFirstAndLastPosition(nums, target)).forEach(value -> System.out.println(value));
    }
}
