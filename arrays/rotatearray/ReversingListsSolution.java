package leetcode.arrays.rotatearray;

public class ReversingListsSolution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};

        ReversingListsSolution.shiftElementsByDPlaces(nums, 3);
    }

    private static void shiftElementsByDPlaces(int[] nums, int d) {
        int actualPositions = d % nums.length;
        reverse(nums, 0, actualPositions-1);
        reverse(nums, actualPositions , nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
