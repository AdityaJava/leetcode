package leetcode.arrays.mergeintervals;

import java.util.*;
import java.util.stream.Collectors;

public class MergeIntervals {

    private int[][] merge(int[][] intervals) {
        List<List<Integer>> listOfElements = mergeIntervals(intervals);
        return listOfElements.toArray(new int[0][]);
    }

    private List<List<Integer>> mergeIntervals(int[][] intervals) {
        List<List<Integer>> intervalsList = getSortedList(intervals);
        List<Integer> currentInterval = new ArrayList<>();
        List<Integer> nextInterval = new ArrayList<>();
        List<Integer> tempInterval = new ArrayList<>();
        int currentIntervalPointer = 0;
        if (intervalsList.size() == 1) {
            return intervalsList;
        }
        while (currentIntervalPointer < intervalsList.size() - 1) {
            currentInterval = intervalsList.get(currentIntervalPointer);
            nextInterval = intervalsList.get(currentIntervalPointer + 1);
            if (currentInterval.get(1) >= nextInterval.get(0)) {
                tempInterval = new ArrayList<>();
                tempInterval.add(currentInterval.get(0));
                tempInterval.add(nextInterval.get(1));
                intervalsList.remove(currentInterval);
                intervalsList.remove(nextInterval);
                intervalsList.add(currentIntervalPointer, tempInterval);
            } else {
                currentIntervalPointer++;
            }
        }
        return intervalsList;
    }

    private List<List<Integer>> getSortedList(int[][] intervals) {
        List<List<Integer>> intervalsList =
                Arrays.stream(intervals).map(ints -> {
                    return Arrays.stream(ints).boxed().collect(Collectors.toList());
                }).collect(Collectors.toList());

        Collections.sort(intervalsList, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int result = o1.get(0).compareTo(o2.get(0));
                if (result == 0) {
                    return o1.get(1).compareTo(o2.get(1));
                }
                return result;
            }
        });
        return intervalsList;
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] intervals = {{15, 20}, {5, 10}, {35, 40}, {25, 30}, {10, 15}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.println(mergeIntervals.mergeIntervals(intervals));

        mergeIntervals.merge(intervals);
    }
}
