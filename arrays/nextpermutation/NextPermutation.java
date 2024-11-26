package leetcode.arrays.nextpermutation;

import leetcode.Swapper;

/*
The steps are the following:

Find the break-point, i: Break-point means the first index i from the back of the given array where arr[i] becomes smaller than arr[i+1].
For example, if the given array is {2,1,5,4,3,0,0}, the break-point will be index 1(0-based indexing). Here from the back of the array, index 1 is the first index where arr[1] i.e. 1 is smaller than arr[i+1] i.e. 5.
To find the break-point, using a loop we will traverse the array backward and store the index i where arr[i] is less than the value at index (i+1) i.e. arr[i+1].

If such a break-point does not exist i.e. if the array is sorted in decreasing order, the given permutation is the last one in the sorted order of all possible permutations. So, the next permutation must be the first i.e. the permutation in increasing order.
So, in this case, we will reverse the whole array and will return it as our answer.

If a break-point exists:
Find the smallest number i.e. > arr[i] and in the right half of index i(i.e. from index i+1 to n-1) and swap it with arr[i].
Reverse the entire right half(i.e. from index i+1 to n-1) of index i. And finally, return the array.

 */
//NOte: Dip index is a point after the remaining elements are in decreasing order
public class NextPermutation {

    private void findNextPermutation(int[] nums) {
        //Step1: To find the dipIndex. This is the index from where the remaining elements starts decreasing
        int n = nums.length;
        int dipIndex = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                dipIndex = i;
                break;
            }
        }

        if (dipIndex != -1) {
            //Step2: Swap with the first small greater element from right side
            for (int i = n - 1; i > dipIndex; i--) {
                if (nums[i] > nums[dipIndex]) {
                    Swapper.swap(nums, i, dipIndex);
                    break;
                }
            }
            //Step3: Reverse the list from next element from dipIndex
            reverseFrom(nums, dipIndex + 1, nums.length - 1);
        }
        //This is used in case of last permutation in that case we return first permutation
        //This is for end permutation like for [3,2,1] the ans will be[1,2,3]
        else {
            reverseFrom(nums, 0, nums.length - 1);
        }
    }

    private static void reverseFrom(int[] nums, int fromPosition, int toPosition) {
        int i = fromPosition;
        int j = toPosition;

        while (i < j) {
            Swapper.swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        //int[] nums = {2, 1, 5, 4, 3, 0, 0};
        int[] nums = {3, 2, 1};

        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.findNextPermutation(nums);
//        NextPermutation.reverseFrom(nums, 1, nums.length - 1);
        System.out.println("sd");
    }
}
