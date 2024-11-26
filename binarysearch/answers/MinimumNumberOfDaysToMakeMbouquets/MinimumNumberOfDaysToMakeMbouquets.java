package leetcode.binarysearch.answers.MinimumNumberOfDaysToMakeMbouquets;

import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfDaysToMakeMbouquets {

    public int minDays(int[] bloomDay, int m, int k) {
        List<Integer> minMax = getMinMax(bloomDay);
        int low = minMax.get(0);
        int high = minMax.get(1);
        int mid = -1;
        boolean isBouquetPossible = false;
        int answer = -1;

        if ((m * k) > bloomDay.length) return -1;

        while (low <= high) {
            mid = (low + high) / 2;
            isBouquetPossible = isBouquetPossible(bloomDay, m, k, mid);
            if (isBouquetPossible) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    private boolean isBouquetPossible(int[] bloomDays, int bouquetsToMake, int adjacentFlowersToUse, int bloomDayConsidered) {
        int bloomedFlowersCount = 0;
        int bouquetsCanBeMade = 0;
        for (int bloomDay : bloomDays) {
            if (bloomDay <= bloomDayConsidered) {
                bloomedFlowersCount++;
            } else {
                bouquetsCanBeMade += bloomedFlowersCount / adjacentFlowersToUse;
                bloomedFlowersCount = 0;
            }
        }
        bouquetsCanBeMade += bloomedFlowersCount / adjacentFlowersToUse;

        if (bouquetsCanBeMade >= bouquetsToMake) {
            return true;
        }
        return false;
    }

    private List<Integer> getMinMax(int[] bloomDays) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int bloomDay : bloomDays) {
            if (bloomDay > max) {
                max = bloomDay;
            }
            if (bloomDay < min) {
                min = bloomDay;
            }
        }
        return Arrays.asList(min, max);
    }

    public static void main(String[] args) {
//        int[] bloomDays = {1, 10, 3, 10, 2};
//        int m = 3, k = 1;

        int[] bloomDays = {7, 7, 7, 7, 12, 7, 7};
        int m = 2, k = 3;

        MinimumNumberOfDaysToMakeMbouquets minimumNumberOfDaysToMakeMbouquets = new MinimumNumberOfDaysToMakeMbouquets();
        System.out.println(minimumNumberOfDaysToMakeMbouquets.minDays(bloomDays, m, k));
    }
}
