package leetcode.binarysearch.onedimenarrays.binarysearch;

//USed to search on Sorted array
public class BinarySearch {

    private static int binarySearch(int low, int high, int[] arr, int key) {

        if (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            } else {
                if (key < arr[mid]) {
                    return binarySearch(low, mid - 1, arr, key);
                } else {
                    return binarySearch(mid + 1, high, arr, key);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 6};
        int key = 6;
        int pos = BinarySearch.binarySearch(0, arr.length - 1, arr, key);
        System.out.println(pos);
    }

}
