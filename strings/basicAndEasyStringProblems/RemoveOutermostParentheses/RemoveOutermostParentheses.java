package leetcode.strings.basicAndEasyStringProblems.RemoveOutermostParentheses;

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        String temp = new String();
        int count = 0;
        boolean start = true;

        for (String c : s.split("")) {
            if (c.equals("(")) {
                count++;
            } else if (c.equals(")")) {
                count--;
            }
            if (count != 0 && !start) {
                temp = temp + c;
            }
            start = false;
            if (count == 0) {
                start = true;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
//        String s = "(()())(())";

        String s = "(()())(())(()(()))";
        RemoveOutermostParentheses removeOutermostParentheses = new RemoveOutermostParentheses();
        System.out.println(removeOutermostParentheses.removeOuterParentheses(s));
    }
}
