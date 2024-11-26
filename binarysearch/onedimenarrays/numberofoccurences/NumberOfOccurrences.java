package leetcode.binarysearch.onedimenarrays.numberofoccurences;

public class NumberOfOccurrences {

    private static int count(int[] arr, int x) {
        int firstOccurence = firstOccurrence(arr, x);
        if (firstOccurence != -1) {
            int lastOccurrence = lastOccurrence(arr, x);
            return lastOccurrence - firstOccurence + 1;
        }
        return 0;
    }

    private static int firstOccurrence(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int mid = -1;
        int firstOccurrence = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (x <= arr[mid]) {
                firstOccurrence = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return firstOccurrence;
    }

    private static int lastOccurrence(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int mid = -1;
        int lastOccurrence = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (x >= arr[mid]) {
                lastOccurrence = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return lastOccurrence;
    }


    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int x = 2;
//
//        int[] arr = {1, 1, 2, 2, 2, 2, 3};
//        int x = 4;

        System.out.println(NumberOfOccurrences.count(arr, x));
    }
}
