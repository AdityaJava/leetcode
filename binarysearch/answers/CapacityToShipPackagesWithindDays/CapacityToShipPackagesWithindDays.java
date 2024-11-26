package leetcode.binarysearch.answers.CapacityToShipPackagesWithindDays;

import java.util.*;

public class CapacityToShipPackagesWithindDays {

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
        int daysUsed = 1;
        int sumOfWeights = 0;
        for (int i = 0; i < weights.length; i++) {
            sumOfWeights += weights[i];
            if (sumOfWeights > capacity) {
                sumOfWeights = weights[i];
                daysUsed++;
            }
            if (sumOfWeights == capacity) {
                sumOfWeights = 0;
                daysUsed++;
            }
        }
        if (daysUsed <= days) {
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
//        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int days = 5;

//        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int days = 1;

        int[] weights = {3, 3, 3, 3, 3, 3};
        int days = 2;

        CapacityToShipPackagesWithindDays capacityToShipPackagesWithindDays = new CapacityToShipPackagesWithindDays();
        System.out.println(capacityToShipPackagesWithindDays.shipWithinDays(weights, days));
    }
}
