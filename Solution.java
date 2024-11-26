package leetcode;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<String, Long> charFrequency = Arrays.asList(s.split("")).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (String tEach : t.split("")) {
            if (charFrequency.get(tEach) == 0) {
                return false;
            }
            charFrequency.put(tEach, charFrequency.get(tEach) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "anagram", t = "nagaram";
        System.out.println(solution.isAnagram(s, t));
    }
}