package leetcode.strings.basicAndEasyStringProblems.IsomorphicString;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> replacement = new HashMap<>();
        char sChar;
        char tChar;
        for (int i = 0; i < s.length(); i++) {
            sChar = s.charAt(i);
            tChar = t.charAt(i);

            if (!replacement.containsKey(sChar) && !replacement.containsKey(tChar)) {
                replacement.put(sChar, tChar);
                replacement.put(tChar, sChar);
            } else {
                if ((replacement.get(sChar) != null && !replacement.get(sChar).equals(tChar)) || !replacement.get(tChar).equals(sChar)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "egg", t = "add";
//        String  s = "foo", t = "bar";
//        String s = "badc", t = "baba";
        String s = "paper", t = "title";


        IsomorphicString isomorphicString = new IsomorphicString();
        System.out.println(isomorphicString.isIsomorphic(s, t));
    }
}
