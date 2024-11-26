package leetcode.strings.basicAndEasyStringProblems.validanagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagramUsingSorting(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        s = new String(sChars);
        t = new String(tChars);
        return s.equals(t);
    }

    public boolean isAnagramUsingFrequency(String s, String t) {
        Map<Character, Integer> frequency = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        char sChar;
        char tChar;
        for (int i = 0; i < s.length(); i++) {
            sChar = s.charAt(i);
            tChar = t.charAt(i);
            if (frequency.containsKey(sChar)) {
                frequency.put(sChar, frequency.get(sChar) + 1);
            } else if (!frequency.containsKey(sChar)) {
                frequency.put(sChar, 1);
            }
            if (frequency.containsKey(tChar)) {
                frequency.put(tChar, frequency.get(tChar) - 1);
            } else if (!frequency.containsKey(tChar)) {
                frequency.put(tChar, -1);
            }
        }
        return frequency.values().stream().filter(value -> value != 0).count() == 0;
    }

    public static void main(String[] args) {
        String s = "a", t = "a";
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagramUsingFrequency(s, t));
    }
}
