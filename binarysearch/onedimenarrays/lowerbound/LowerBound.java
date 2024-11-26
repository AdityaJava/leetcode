package leetcode.binarysearch.onedimenarrays.lowerbound;

public class LowerBound {

    private static int findLowerBound(int[] arr, int x) {
        int high = arr.length;
        int low = 0;
        int mid = -1;
        int answer = arr.length;

        while (low <= high) {
            mid = (low + high) / 2;

            if (x <= arr[mid]) {
                answer = mid;

                //Look for smaller index on left as it is sorted array
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int x = 9;
        int ind = findLowerBound(arr, x);
        System.out.println("The lower bound is the index: " + ind);

    }
}
