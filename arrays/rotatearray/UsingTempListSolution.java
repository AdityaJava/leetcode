package leetcode.arrays.rotatearray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class UsingTempListSolution {
    public static void rotate(int[] nums, int k) {
        int actualRotations = k % nums.length;
        List<Integer> temp = new ArrayList<>();
        int tempPos = 0;
        boolean flag =false;
        for(int i=0; i<nums.length; i++) {
            if(i<actualRotations) {
                temp.add(nums[i]);
            }
            else {
                nums[i - actualRotations] = nums[i];
            }
            if(flag || ((nums.length - i)==actualRotations)){
                flag =true;
                nums[i] = temp.get(tempPos);
                tempPos++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        UsingTempListSolution.rotate(nums, 3);

        Arrays.asList(nums).stream().forEach(e -> System.out.println(e));

    }
}