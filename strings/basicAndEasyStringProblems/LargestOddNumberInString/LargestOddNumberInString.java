package leetcode.strings.basicAndEasyStringProblems.LargestOddNumberInString;

public class LargestOddNumberInString {
    public String largestOddNumber(String num) {
        int pointer = num.length() - 1;
        while (pointer >= 0) {
            Long number = Long.valueOf(num.substring(pointer, pointer + 1));
            if (number % 2 != 0) {
                return num.substring(0, pointer + 1);
            }
            pointer--;
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "52";
        LargestOddNumberInString largestOddNumberInString = new LargestOddNumberInString();
        System.out.println(largestOddNumberInString.largestOddNumber(s));
    }
}
