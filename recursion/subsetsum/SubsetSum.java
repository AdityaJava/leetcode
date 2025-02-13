package leetcode.recursion.subsetsum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * SubsetSum
 */
public class SubsetSum {

  private void subsetRecursively(int index, int[] arr, int length, ArrayList<Integer> result, int sum) {
    if (index == length) {
      result.add(sum);
      return;
    }
    subsetRecursively(index + 1, arr, length, result, sum + arr[index]);
    subsetRecursively(index + 1, arr, length, result, sum);
  }

  public ArrayList<Integer> subsetSums(int[] arr) {
    ArrayList<Integer> result = new ArrayList<>();
    subsetRecursively(0, arr, arr.length, result, 0);
    Collections.sort(result);
    return result;
  }

  public static void main(String[] args) {
    int arr[] = { 2, 3 };
    SubsetSum subsetSum = new SubsetSum();
    ArrayList<Integer> result = subsetSum.subsetSums(arr);
    result.forEach(System.out::println);
  }
}
