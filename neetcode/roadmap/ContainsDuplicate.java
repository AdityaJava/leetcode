package leetcode.neetcode.roadmap;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> integers = Arrays.stream(nums).boxed().collect(Collectors.toList()).stream().collect(Collectors.toSet());
        return nums.length != integers.size() ? true : false;
    }
}