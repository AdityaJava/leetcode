package leetcode.binarysearch.answers.FindKthPositive;

import java.util.Map;

public class FindKthPositiveOptimal {

    public int findKthPositiveOptimal(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int mid = -1;
        int missing = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        int moreNeeded = k - missing;

        //1. We know missing = arr[high]-(high + 1);
        //2. We know missingNumber = arr[high] + moreNeeded;
        //3. We know  moreNeeded = k - missing

        //4. Now Substitute missing = arr[high]-(high + 1);
        //5. So now moreNeeded = k - (arr[high]-(high + 1));

        //6. We know missingNumber = arr[high] + moreNeeded
        //7. Now Substitute moreNeeded = k - (arr[high]-(high + 1));
        //8. So now missingNumber = arr[high] + k - arr[high] + high + 1;
        //9. missingNumber = k + high +1;

        int missingNumber = k + high + 1;
        return missingNumber;
    }

    public static void main(String[] args) {
//        int[] arr = {2, 3, 4, 7, 11};
//        int k = 5;

        int[] arr = {2};
        int k = 1;


        FindKthPositiveOptimal findKthPositiveOptimal = new FindKthPositiveOptimal();

        System.out.println(findKthPositiveOptimal.findKthPositiveOptimal(arr, k));
    }
}
