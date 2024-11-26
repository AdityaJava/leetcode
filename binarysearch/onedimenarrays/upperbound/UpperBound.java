package leetcode.binarysearch.onedimenarrays.upperbound;

public class UpperBound {

    private static int findUpperBound(int[] arr, int x) {
        int high = arr.length;
        int low = 0;
        int mid = -1;
        int answer = arr.length;

        while (low <= high) {
            mid = (low + high) / 2;

            if (x >= arr[mid]) {
                answer = mid;

                //Look for more greater numbers on right
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 9, 15, 19};
        int n = 6, x = 9;
        int ind = findUpperBound(arr, x);
        System.out.println("The upper bound is the index: " + ind);
    }
}
