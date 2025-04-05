package leetcode.recursionandbacktracking.wordbreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * WordBreak
 */
public class WordBreak {
    public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
        ArrayList<String> answers = new ArrayList<>();
        recursiveWordBreak(s, 0, dictionary, answers, new String());
        return answers;
    }

    private static void recursiveWordBreak(String s, int beginIndex, ArrayList<String> dictionary, List<String> answers, String answer) {
        if (beginIndex == s.length()) {
            answers.add(answer);
            return;
        }
        String temp = new String();
        for (int i = beginIndex; i < s.length(); i++) {
            temp = s.substring(beginIndex, i + 1);
            if (dictionary.contains(temp)) {
                recursiveWordBreak(s, i + 1, dictionary, answers, answer + " " + temp);
            }
        }
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        ArrayList<String> dict = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        WordBreak.wordBreak(s, dict).forEach(eachWord -> System.out.println(eachWord));
    }
}
