package leetcode.twonumbersaddionlinkedlist;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubStringWIthoutRepeatingChar {
    public static void main(String[] args) {
        System.out.println(dynamicSlidingWindow("abcabcbb"));
    }

    public static int dynamicSlidingWindow(String str) {
        List<String> s = Arrays.asList(str.split(""));
        int left = 0, right = 0;
        int maxLength = 0;
        Set<String> visited = new HashSet<>();
        if(str.isEmpty()){
            return 0;
        }
        while (right < s.size()) {
            System.out.println(s.get(right));
            while (visited.contains(s.get(right))) {
                visited.remove(s.get(left));
                left++;
            }
            visited.add(s.get(right));
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}