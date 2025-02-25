package leetcode.greedyalgorithm.minimumplatforms;

import java.util.Arrays;

/**
 * MinimumPlatforms
 */
public class MinimumPlatforms {

  static int findPlatform(int arr[], int dep[]) {
    if (arr.length == 1) {
      return 1;
    }
    Arrays.sort(arr);
    Arrays.sort(dep);
    int arrPointer = 0;
    int depPointer = 0;
    int maxPlatforms = 0;
    int platforms = 0;
    while ((arrPointer <= arr.length - 1)) {
      if (arr[arrPointer] <= dep[depPointer]) {
        platforms++;
        arrPointer++;
      }
      else {
        platforms--;
        depPointer++;
      }
      maxPlatforms = Math.max(platforms, maxPlatforms);
    }
    return maxPlatforms;
  }

  public static void main(String[] args) {
    //    int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
    //    int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };

    int[] arr = { 1114, 825, 357, 1415, 54 };
    int[] dep = { 1740, 1110, 2238, 1535, 2323 };

    //    int[] arr = { 1114, 825, 357, 1415, 54 };
    //    int[] dep = { 1740, 1110, 2238, 1535, 2323 };

    System.out.println(MinimumPlatforms.findPlatform(arr, dep));
  }
}
