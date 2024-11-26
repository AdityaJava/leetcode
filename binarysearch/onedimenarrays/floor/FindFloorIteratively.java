package leetcode.binarysearch.onedimenarrays.floor;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FindFloorIteratively {
    private static int findFloorIteratively(long arr[], int n, long x) {

        int median = 0;
        int high = arr.length - 1;
        int low = 0;
        int answer = arr.length;

        while (high >= low) {
            median = (low + high) / 2;
            if (arr[median] == x) {
                answer = median;
                return answer;
            } else if (arr[median] >= x) {
                high = median - 1;
            } else if (arr[median] < x) {
                answer = median;
                low = median + 1;
            }
        }

        if (answer == arr.length) {
            return -1;
        }
        return answer;
    }

    public static void main(String[] args) {
//        long[] arr = {1, 2, 8, 10, 11, 12, 19};
//        int x = 0;
//        String arrString = "35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109 110 111 112 113";
//        long[] arr = FindFloorIteratively.getArray(arrString);
//        int x = 159;

        String arrString = "44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105 106 107 108 109 110 111";
        long[] arr = FindFloorIteratively.getArray(arrString);
        int x = 100;


        System.out.println(FindFloorIteratively.findFloorIteratively(arr, arr.length, x));
    }

    private static long[] getArray(String s) {
        String arrString = s;
        return Arrays.stream(arrString.split(" ")).mapToLong(Long::parseLong).toArray();
    }
}
