package leetcode.binarysearch.onedimenarrays.binarysearch;

public class BinarySearchRecursive {

    private int binarySearchRecursive(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;

        if (nums[mid] == target) return mid;

        else if (nums[mid] > target) {
            return binarySearchRecursive(nums, low, mid - 1, target);
        } else {
            return binarySearchRecursive(nums, mid + 1, high, target);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        BinarySearchRecursive binarySearchRecursive = new BinarySearchRecursive();

        System.out.println(binarySearchRecursive.binarySearchRecursive(nums, 0, nums.length - 1, target));
    }
}
