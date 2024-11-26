package leetcode.arrays.majorityelement3;

import java.util.ArrayList;
import java.util.List;

//Moore's Extended algorithm
//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
public class MajorityElement {

    //Why only 2 elements can be there
    //Answer: Suppose 8/3 = 2  so we need to find element occuring greater than 2 times
    // That is the number should atleast appear 3 times so 3 + 3 =6 and remaining 2 to make 8. So only 2 elements can be
    // Greater that n/3 times
    private List<Integer> findElementsMoreThanNBy3(int[] nums) {
        int count1 = 0, mightBeMajorityElement1 = 0;
        int count2 = 0, mightBeMajorityElement2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && nums[i] != mightBeMajorityElement2) {
                mightBeMajorityElement1 = nums[i];
                count1 = 1;
            } else if (count2 == 0 && nums[i] != mightBeMajorityElement1) {
                mightBeMajorityElement2 = nums[i];
                count2 = 1;
            } else if (mightBeMajorityElement1 == nums[i]) {
                count1++;
            } else if (mightBeMajorityElement2 == nums[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == mightBeMajorityElement1) {
                count1++;
            } else if (nums[i] == mightBeMajorityElement2) {
                count2++;
            }
        }

        List<Integer> answers = new ArrayList<>();
        if (count1 > (nums.length / 3)) {
            answers.add(mightBeMajorityElement1);
        }
        if (count2 > (nums.length / 3)) {
            answers.add(mightBeMajorityElement2);
        }
        return answers;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 3};
        MajorityElement majorityElement = new MajorityElement();
        majorityElement.findElementsMoreThanNBy3(nums).forEach(e -> System.out.println(e));
    }
}
