package leetcode.strings.basicAndEasyStringProblems.ReverseWordInString;

public class ReverseWordInString {
    public String reverseWords(String s) {
        String result = new String();
        int i = 0, j = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ')
                i++;
            j = i;
            while (j < s.length() && s.charAt(j) != ' ')
                j++;
            if (result.equals("")) {
                result = s.substring(i, j);
            } else if (!s.substring(i, j).equals(" ")) {
                result = s.substring(i, j) + " " + result;
            }
            i = j;
        }
        return result.strip();
    }

    public static void main(String[] args) {
//        String s = "the sky is blue";
        String s = "  hello world  ";
        ReverseWordInString reverseWordInString = new ReverseWordInString();
        System.out.println("--"+reverseWordInString.reverseWords(s)+"--");
    }
}
