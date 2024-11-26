package leetcode.binarysearch.answers.SplitArray;

import java.util.*;
import java.util.stream.Collectors;

public class SplitArray {

    public int splitArray(int[] nums, int k) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        List<Integer> sumAndMax = getSumAndMax(arr);
        int low = sumAndMax.get(1);
        int high = sumAndMax.get(0);
        int mid = -1;
        int answer = -1;
        int currentArrayCapacity;
        while (low <= high) {
            mid = (low + high) / 2;
            currentArrayCapacity = calculateCurrentArrayCapacity(arr, mid, k);
            if (currentArrayCapacity == -1) {
                low = mid + 1;
            } else if (currentArrayCapacity == 0 || currentArrayCapacity == 1) {
                high = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }

    private int calculateCurrentArrayCapacity(ArrayList<Integer> nums, int arrayCapacity, int requiredNumberOfSubArrays) {
        int sum = 0;
        int numberOfSubarrays = 1;
        for (int i = 0; i < nums.size(); i++) {
            sum = sum + nums.get(i);
            if (sum > arrayCapacity) {
                sum = nums.get(i);
                numberOfSubarrays++;
            }
        }
        if (numberOfSubarrays > requiredNumberOfSubArrays) {
            return -1;
        } else if (numberOfSubarrays == requiredNumberOfSubArrays) {
            return 0;
        }
        return 1;
    }

    private List<Integer> getSumAndMax(ArrayList<Integer> arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int element : arr) {
            sum = sum + element;
            if (max < element) {
                max = element;
            }
        }
        return Arrays.asList(sum, max);
    }

    public static void main(String[] args) {
        SplitArray splitArray = new SplitArray();
//        int k = 2;
//        int [] nums = {7, 2, 5, 10, 8};
//

//        int k = 2;
//        int[] nums = {1, 2, 3, 4, 5};

        int k = 5;
        int[] nums = {2, 3, 1, 1, 1, 1, 1};

        System.out.println(splitArray.splitArray(nums, k));
    }
}
