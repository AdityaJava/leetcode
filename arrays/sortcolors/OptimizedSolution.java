package leetcode.arrays.sortcolors;

/* Problem
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.


Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]

Link https://leetcode.com/problems/sort-colors/description/
 */

/* Dutch National flag algorithm

mid=0
low=0
high=n-1

1.  if a[mid] = 0
     then swap(a[low], a[mid])
     low++, mid++

2. if a[mid]= 1
    then mid++

3. if a[mid] = 2
   then swap(a[mid], a[high])
   high--

video link: https://www.youtube.com/watch?v=tp8JIuCXBaU
*/

// DUtch National FLag ALgo
public class OptimizedSolution {

    public void sortColors(int[] nums) {

        int low = 0, mid = 0, high = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[mid] == 0) {
                swap(low, mid, nums);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                swap(mid, high, nums);
                high--;
            }
        }
    }

    private void swap(int pos1, int pos2, int[] arr) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        OptimizedSolution sortColors = new OptimizedSolution();
        sortColors.sortColors(nums);
        System.out.println("mj");
    }

}

