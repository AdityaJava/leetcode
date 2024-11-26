package leetcode.binarysearch.onedimenarrays.findfirstandlastpos;

import java.util.Arrays;

public class FindFirstAndLastPosition {

    private static int[] findFirstAndLastPosition(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = -1;
        int left = -1;
        int right = -1;
        while (high >= low) {
            mid = (high + low) / 2;
            if (nums[mid] == target) {
                left = mid;
                right = mid;
                while ((left - 1) >= 0 && nums[left - 1] == target) {
                    left--;
                }
                while ((right + 1) < nums.length && nums[right + 1] == target) {
                    right++;
                }
                break;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        Arrays.stream(FindFirstAndLastPosition.findFirstAndLastPosition(nums, target)).forEach(value -> System.out.println(value));
    }
}
