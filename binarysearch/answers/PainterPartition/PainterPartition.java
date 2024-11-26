package leetcode.binarysearch.answers.PainterPartition;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PainterPartition {

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int high = getSumAndMax(boards).get(0);
        int low = getSumAndMax(boards).get(1);
        int mid = -1;
        boolean isBoardsPaintingPossible;
        int answer = -1;
        while (low <= high) {
            mid = (high + low) / 2;
            isBoardsPaintingPossible = isBoardsPaintingPossible(boards, k, mid);
            if (isBoardsPaintingPossible) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    private static boolean isBoardsPaintingPossible(ArrayList<Integer> boards, int numberOfPainters, int maxTimeOnePainterCanPaint) {
        int sumOfTimeToPaintBoards = 0;
        int numberOfPaintersRequired = 1;
        for (int timeToPaintBoards : boards) {
            sumOfTimeToPaintBoards = sumOfTimeToPaintBoards + timeToPaintBoards;
            if (sumOfTimeToPaintBoards > maxTimeOnePainterCanPaint) {
                numberOfPaintersRequired++;
                sumOfTimeToPaintBoards = timeToPaintBoards;
            }
        }
        if (numberOfPaintersRequired > numberOfPainters) {
            return false;
        }
        return true;
    }

    private static List<Integer> getSumAndMax(ArrayList<Integer> boards) {
        Integer sum = 0;
        Integer max = Integer.MIN_VALUE;
        for (Integer board : boards) {
            sum = sum + board;
            if (max < board) {
                max = board;
            }
        }
        return Arrays.asList(sum, max);
    }

    public static void main(String[] args) {
//        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2, 3));
//        int k = 2;

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(8, 6, 10, 3, 2, 7, 10));
        int k = 7;


        System.out.println(PainterPartition.findLargestMinDistance(arr, k));
    }
}