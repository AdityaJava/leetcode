package leetcode;


import java.util.Arrays;
import java.util.List;

/**
 * This is used to find the max sum of consecutive elements etc
 */
public class StaticSlidingWindowTechnique {

    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(1, 3, 4, 5, 12, 6, 7, 8);
        System.out.println(findMaxSumByStaticSlidingWindowTechnique(5, elements));
    }

    public static int findMaxSumByStaticSlidingWindowTechnique(int noOfElementsInWindow, List<Integer> elements) {
        int maxSum = 0;
        int windowSum = 0;
        for (int i = 0; i < noOfElementsInWindow; i++) {
            windowSum += elements.get(i);
        }
        maxSum = windowSum;
        for (int i = noOfElementsInWindow; i < elements.size(); i++) {
            windowSum = maxSum + elements.get(i) - elements.get(i - noOfElementsInWindow);
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

}
