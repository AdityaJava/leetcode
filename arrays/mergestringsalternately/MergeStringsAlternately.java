package leetcode.arrays.mergestringsalternately;

public class MergeStringsAlternately {
    private String mergeStringsAlternately(String word1, String word2) {
        String word3 = new String();
        int word1Position = 0;
        int word2Position = 0;
        boolean word1Turn = true;
        while (word1Position < word1.length() || word2Position < word2.length()) {

            if (word1Position < word1.length() && word1Turn) {
                word3 = word3 + word1.charAt(word1Position);
                word1Position++;
                word1Turn = false;
            } else if (word2Position < word2.length() && !word1Turn) {
                word3 = word3 + word2.charAt(word2Position);
                word2Position++;
                word1Turn = true;
            }

            if (word1Position >= word1.length()) word1Turn = false;
            if (word2Position >= word2.length()) word1Turn = true;
        }
        return word3;
    }

    public static void main(String[] args) {
        // String word1 = "abc", word2 = "pqr";
        String word1 = "ab", word2 = "pqrs";
        MergeStringsAlternately mergeStringsAlternately = new MergeStringsAlternately();
        String string3 = mergeStringsAlternately.mergeStringsAlternately(word1, word2);
        System.out.println(string3);
    }
}
