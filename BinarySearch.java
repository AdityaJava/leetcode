package leetcode;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 16, 20, 25, 29);
        System.out.println(doBinarySearch(integerList, 99));
    }

    private static int doBinarySearch(List<Integer> integerList, int searchKey) {
        int low = 0, high = integerList.size() - 1, medium = 0;

        while (low <= high) {
            medium = Math.abs((high + low) / 2);
            if (medium < integerList.size() && integerList.get(medium) == searchKey) {
                return medium;
            } else if (searchKey > medium) {
                low = medium + 1;
            } else if (searchKey < medium) {
                high = medium - 1;
            }
        }
        return -1;
    }
}
