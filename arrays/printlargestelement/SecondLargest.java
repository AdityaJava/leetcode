package leetcode.arrays.printlargestelement;

import java.util.Arrays;
import java.util.List;

public class SecondLargest {
    public int print2largest(List<Integer> arr) {
        int max1 = arr.get(0);
        int max2 = -1;

        for (Integer e : arr) {

            if (max1 < e) {
                max2 = max1;
                max1 = e;
            } else if (max2 < e && e!=max1) {
                max2 = e;
            }

        }
        return max2;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(19398);
        SecondLargest secondLargest = new SecondLargest();
        secondLargest.print2largest(arr);
    }
}