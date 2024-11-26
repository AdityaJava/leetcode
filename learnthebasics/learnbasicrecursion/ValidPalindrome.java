package leetcode.learnthebasics.learnbasicrecursion;

import java.util.Locale;

public class ValidPalindrome {

    private boolean isValidPalindrome(int position, String str) {
        int low = position;
        int high = str.length() - 1 - position;
        if (low > high) {
            return true;
        } else if (str.charAt(low) == str.charAt(high)) {
            return isValidPalindrome(position + 1, str);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "a.";
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isValidPalindrome(0, s));
    }
}
