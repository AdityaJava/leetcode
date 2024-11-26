package leetcode.binarysearch.onedimenarrays.searchinrotatedsortedarray;

public class SearchInRotatedSortedArrayForUniqueElements {

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = -1;

        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) return mid;

            //1st Step is to identify the sorted portion and search there
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && nums[mid] >= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            //nums[mid]<nums[low]
            else {
                if (nums[mid] <= target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

//        int [] nums {4,5,6,7,0,1,2};
        System.out.println(SearchInRotatedSortedArrayForUniqueElements.search(nums, 0));
    }
}
