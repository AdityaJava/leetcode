package leetcode.arrays.majorityelementbymooresvotingalgorithm;

public class MooresVotingAlgorithm {

    private static int findMajorityElementByMooresVotingAlgorithm(int[] nums) {
        int mightBeMajorityelement = nums[0], count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                mightBeMajorityelement = nums[i];
            }
            if (mightBeMajorityelement == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == mightBeMajorityelement) {
                count++;
            }
        }

        if (count > ((nums.length) / 2)) {
            return mightBeMajorityelement;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5};
        System.out.println(MooresVotingAlgorithm.findMajorityElementByMooresVotingAlgorithm(nums));
    }
}
