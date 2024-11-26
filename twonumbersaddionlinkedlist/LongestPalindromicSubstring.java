package leetcode.twonumbersaddionlinkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(checkPalidromic("abac"));
    }
    public static boolean checkPalidromic(String s){
        int i=0, j=s.length()-1;
        boolean isPalindrome = true;

        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else{
                isPalindrome=false;
                break;
            }
        }
        return isPalindrome;

    }

}

