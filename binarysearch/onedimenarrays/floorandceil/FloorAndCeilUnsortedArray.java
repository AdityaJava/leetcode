package leetcode.binarysearch.onedimenarrays.floorandceil;

import java.util.Arrays;

public class FloorAndCeilUnsortedArray {

    private static int[] getFloorAndCeil(int x, int[] arr) {
        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] <= x && arr[i] > floor) {
                floor = arr[i];
            }
            if (arr[i] >= x && arr[i] < ceil) {
                ceil = arr[i];
            }
        }

        if (floor == Integer.MIN_VALUE) {
            floor = -1;
        }
        if (ceil == Integer.MAX_VALUE) {
            ceil = -1;
        }
        return new int[]{floor, ceil};
    }

    public static void main(String[] args) {
//        int[] arr = {5, 6, 8, 9, 6, 5, 5, 6};
//        int x = 7;

//        int[] arr = {5, 6, 8, 8, 6, 5, 5, 6};
//        int x = 10;

        int[] arr = {36, 82, 88, 56, 21, 17, 73, 86};
        int x = 17;

        Arrays.stream(FloorAndCeilUnsortedArray.getFloorAndCeil(x, arr)).forEach(value -> System.out.println(value));
    }
}
