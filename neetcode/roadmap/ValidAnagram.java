package leetcode.neetcode.roadmap;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<String, Long> charFrequency = Arrays.asList(s.split("")).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (String tEach : t.split("")) {
            if (charFrequency.get(tEach) == null) {
                return false;
            }
            charFrequency.put(tEach, charFrequency.get(tEach) - 1);
        }
        return true;
    }

}