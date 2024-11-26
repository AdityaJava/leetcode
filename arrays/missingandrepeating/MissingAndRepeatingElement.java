package leetcode.arrays.missingandrepeating;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MissingAndRepeatingElement {

    private static int[] findMissingAndRepeatingElement(int arr[], int n) {
        int xor = 0;
        int duplicateELement = 0;
        Map<Integer, Integer> elementToCount = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!elementToCount.containsKey(arr[i])) {
                xor = xor ^ arr[i];
                elementToCount.put(arr[i], 1);
            } else {
                duplicateELement = arr[i];
            }
        }
        int originalXOR = 0;
        for (int i = 0; i <= n; i++) {
            originalXOR = originalXOR ^ i;
        }
        int missingNumber = xor ^ originalXOR;
        return new int[]{duplicateELement, missingNumber};
    }

    public static void main(String[] args) {
        int[] arr = {12, 7, 5, 1, 13, 1, 10, 8, 11, 9, 2, 4, 3, 6};
        System.out.println(MissingAndRepeatingElement.findMissingAndRepeatingElement(arr, arr.length));

        Arrays.stream(MissingAndRepeatingElement.findMissingAndRepeatingElement(arr, arr.length)).forEach(value -> System.out.println(value));
    }
}
