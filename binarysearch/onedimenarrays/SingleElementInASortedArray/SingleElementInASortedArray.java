package leetcode.binarysearch.onedimenarrays.SingleElementInASortedArray;

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = -1;

        if (nums.length == 1) {
            return nums[0];
        }

        while (low <= high) {
            mid = (high + low) / 2;

            if (mid == 0 && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            if ((nums.length - 1) == mid && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }

            if (mid % 2 == 0) {
                if (nums[mid - 1] == nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid + 1] == nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] nums = {1, 2, 2, 3, 3, 4, 4, 8, 8};

        SingleElementInASortedArray singleElementInASortedArray = new SingleElementInASortedArray();
        System.out.println(singleElementInASortedArray.singleNonDuplicate(nums));
    }
}
