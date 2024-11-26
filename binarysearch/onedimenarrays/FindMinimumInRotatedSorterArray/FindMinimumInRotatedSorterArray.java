package leetcode.binarysearch.onedimenarrays.FindMinimumInRotatedSorterArray;

public class FindMinimumInRotatedSorterArray {


    private int findMinimumInRotatedSorterArray(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = -1;
        int minimum = Integer.MAX_VALUE;

        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[low] <= nums[mid]) {
                if (minimum > nums[low]) {
                    minimum = nums[low];
                }
                low = mid + 1;
            } else {
                if (minimum > nums[mid]) {
                    minimum = nums[mid];
                }
                high = mid - 1;
            }
        }
        return minimum;
    }

    public static void main(String[] args) {

    }
}
