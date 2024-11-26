package leetcode.binarysearch.answers.CapacityToShipPackagesWithindDays;

import java.util.Arrays;
import java.util.List;

public class CapacityToShipPackagesWithindDays2 {

    public int shipWithinDays(int[] weights, int days) {
        List<Integer> maxAndSum = getMaxAndSum(weights);
        int low = maxAndSum.get(0);
        int high = maxAndSum.get(1);
        int mid = -1;
        boolean isPossibleToShipWithCapacity = false;
        int answer = -1;

        if (days == 1) {
            return high;
        }

        while (low <= high) {
            mid = (low + high) / 2;
            isPossibleToShipWithCapacity = isPossibleToShipWithCapacity(weights, mid, days);
            if (isPossibleToShipWithCapacity) {
                high = mid - 1;
                answer = mid;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    private boolean isPossibleToShipWithCapacity(int[] weights, int capacity, int days) {
        int weightsSum = 0;
        int dayUsed = 0;
        for (int i = 0; i < weights.length; i++) {
            weightsSum += weights[i];
            if (weightsSum > capacity) {
                dayUsed++;
                weightsSum = weights[i];
            }
        }
        dayUsed++;
        if (dayUsed <= days) {
            return true;
        }
        return false;
    }

    private List<Integer> getMaxAndSum(int[] weights) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int weight : weights) {
            sum += weight;
            if (max < weight) {
                max = weight;
            }
        }
        return Arrays.asList(max, sum);
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        //ans = 15

//        int[] weights = {3, 3, 3, 3, 3, 3};
//        int days = 2;
        //ans=9

        CapacityToShipPackagesWithindDays2 capacityToShipPackagesWithindDays2 = new CapacityToShipPackagesWithindDays2();
        System.out.println(capacityToShipPackagesWithindDays2.shipWithinDays(weights, days));

    }
}
