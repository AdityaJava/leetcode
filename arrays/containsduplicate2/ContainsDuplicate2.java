package leetcode.arrays.containsduplicate2;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {
    private boolean containsDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> visited = new HashMap<>();
        int position = 0;
        int difference = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (visited.containsKey(nums[i])) {
                difference = Math.abs(i - visited.get(nums[i]));
                if (difference <= k) {
                    flag = true;
                    return flag;
                }
            }
            visited.put(nums[i], i);
        }
        return flag;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};
//        int k = 3;
//        int[] nums = {1, 0, 1, 1};
//        int k = 1;
//        int[] nums = {1,2,3,1,2,3};
//        int k = 2;

        int[] nums = {0, 1, 2, 3, 4, 0, 0, 7, 8, 9, 10, 11, 12, 0};
        int k = 1;

        ContainsDuplicate2 containsDuplicate2 = new ContainsDuplicate2();
        containsDuplicate2.containsDuplicate2(nums, k);
    }
}
