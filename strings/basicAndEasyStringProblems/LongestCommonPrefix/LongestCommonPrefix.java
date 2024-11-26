package leetcode.strings.basicAndEasyStringProblems.LongestCommonPrefix;

import java.util.Arrays;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String firstString = strs[0];
        String lastString = strs[strs.length - 1];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            if (firstString.charAt(i) != lastString.charAt(i)) {
                break;
            }
            result.append(firstString.charAt(i));
        }
        return result.toString();
    }


    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }
}
