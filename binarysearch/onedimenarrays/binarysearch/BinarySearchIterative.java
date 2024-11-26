package leetcode.binarysearch.onedimenarrays.binarysearch;

public class BinarySearchIterative {

    private int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) return mid;

            else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        BinarySearchIterative binarySearchIterative = new BinarySearchIterative();
        System.out.println(binarySearchIterative.binarySearch(nums, target));
    }
}
