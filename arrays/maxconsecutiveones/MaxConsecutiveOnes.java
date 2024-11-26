package leetcode.arrays.maxconsecutiveones;

//https://leetcode.com/problems/max-consecutive-ones/

public class MaxConsecutiveOnes {

    private static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }

            if (count > max) {
                max = count;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(MaxConsecutiveOnes.findMaxConsecutiveOnes(nums));
    }
}
