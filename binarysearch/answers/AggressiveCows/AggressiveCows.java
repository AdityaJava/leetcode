package leetcode.binarysearch.answers.AggressiveCows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//You are given the task of assigning stalls to 'k' cows such
// that the minimum distance between any two of them is the maximum possible.
public class AggressiveCows {
    public static int aggressiveCows(int[] stalls, int k) {
        List<Integer> sortedStalls = Arrays.stream(stalls).boxed().sorted().collect(Collectors.toList());
        int distanceTill = sortedStalls.get(sortedStalls.size() - 1) - sortedStalls.get(0);
        int low = 1;
        int high = distanceTill;
        int mid = -1;
        boolean isStallingPossibleWithGivenDistance = false;
        int answer = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            isStallingPossibleWithGivenDistance = checkIfStallingPossibleWithGivenDistance(mid, k, sortedStalls);
            if (isStallingPossibleWithGivenDistance) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

    private static boolean checkIfStallingPossibleWithGivenDistance(Integer distance, int numberOfCows, List<Integer> sortedStalls) {
        //First cow is stalled at stall number sortedStalls.get(0)
        int lastCowStall = sortedStalls.get(0);

        //First cow is stalled at stall number sortedStalls.get(0). So begin from 2nd cow
        int currentCow = 2;

        for (int i = 1; i < sortedStalls.size(); i++) {
            if (Math.abs(lastCowStall - sortedStalls.get(i)) >= distance) {
                currentCow++;
                lastCowStall = sortedStalls.get(i);
            }
        }
        if (currentCow > numberOfCows) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] stalls = {0, 3, 4, 7, 10, 9};
//        int numberOfCows = 4;
        //2
        //4 2 1 3 6
        int[] stalls = {4, 2, 1, 3, 6};
        int numberOfCows = 2;

        System.out.println(AggressiveCows.aggressiveCows(stalls, numberOfCows));
    }
}
