package leetcode.arrays.countinversions;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {

    private long merge(long[] arr, int low, int median, int high) {
        int array1Length = median - low + 1;
        int array2Length = high - median;
        long count = 0;
        long[] array1 = new long[array1Length];
        long[] array2 = new long[array2Length];
        for (int i = 0; i < array1Length; i++) {
            array1[i] = arr[i + low];
        }

        for (int i = 0; i < array2Length; i++) {
            array2[i] = arr[i + median + 1];
        }

        int array1Pointer = 0;
        int array2Pointer = 0;
        int arrPointer = low;

        while (array1Pointer < array1Length && array2Pointer < array2Length) {
            if (array1[array1Pointer] <= array2[array2Pointer]) {
                arr[arrPointer] = array1[array1Pointer];
                array1Pointer++;
            } else {
                arr[arrPointer] = array2[array2Pointer];
                //count += (median - low + 1);
                array2Pointer++;
            }
            arrPointer++;
        }

        while (array1Pointer < array1Length) {
            arr[arrPointer] = array1[array1Pointer];
            array1Pointer++;
            arrPointer++;
        }
        while (array2Pointer < array2Length) {
            arr[arrPointer] = array2[array2Pointer];
            array2Pointer++;
            arrPointer++;
        }
        count = checkInversions(array1, array2);
        return count;
    }

    private long checkInversions(long[] array1, long[] array2) {
        int i = 0, j = 0;
        long count = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] > array2[j]) {
                count = count + (array1.length - i);
                j++;
            } else {
                i++;
            }
        }
        return count;
    }

    private long sort(long[] arr, int low, int high) {
        long count = 0;
        if (low < high) {
            int median = low + (high - low) / 2;
            count += sort(arr, low, median);
            count += sort(arr, median + 1, high);
            count += merge(arr, low, median, high);
        }
        return count;
    }

    public static void main(String[] args) {
//        long[] arr = {2, 4, 1, 3, 5};
        long[] arr = {24, 18, 38, 43, 14, 40, 1, 54};
        long count = 0;
        CountInversions countInversions = new CountInversions();
        count = countInversions.sort(arr, 0, arr.length - 1);
        System.out.println(count);
    }
}
