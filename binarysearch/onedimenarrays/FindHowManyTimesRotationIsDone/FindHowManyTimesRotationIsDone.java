package leetcode.binarysearch.onedimenarrays.FindHowManyTimesRotationIsDone;

import java.util.List;

//This code is same as FindMinimumInRotatedSorterArray
public class FindHowManyTimesRotationIsDone {

    private int findHowManyTimesRotationIsDone(List<Integer> arr) {
        int low = 0;
        int high = arr.size()-1;
        int mid = -1;
        int minimunPosition = -1;
        int minimun = Integer.MAX_VALUE;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr.get(low) <= arr.get(mid)) {
                if (minimun > arr.get(low)) {
                    minimun = arr.get(low);
                    minimunPosition = low;
                }
                low = mid + 1;
            } else {
                if (minimun > arr.get(mid)) {
                    minimun = arr.get(mid);
                    minimunPosition = mid;
                }
                high = mid - 1;
            }
        }
        return minimunPosition;
    }

    public static void main(String[] args) {

    }
}
