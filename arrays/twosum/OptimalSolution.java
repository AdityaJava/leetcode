package leetcode.arrays.twosum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//This is optimal because it doesn't use hashmap
//But this is only optimal if answer should be yes or no
public class OptimalSolution {

    public static boolean twoSum(int[] nums, int target) {
        //
        List<Integer> list = Arrays.stream(nums).sorted().boxed().collect(Collectors.toList());

        int i = 0, j = nums.length - 1;
        int sum = 0;
        while (i < j) {
            sum = list.get(i) + list.get(j);
            if (sum == target) {
                return true;
            } else if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{3, 2, 4};
        int[] arr = new int[]{2, 7, 11, 15};

        System.out.println(twoSum(arr, 9));
    }

}
