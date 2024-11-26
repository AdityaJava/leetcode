package leetcode.twonumbersaddionlinkedlist;

import java.util.*;

public class ValidParenthesis {
    public static void main(String[] args) {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        //System.out.println(validParenthesis.isValid("()[]{}"));
       // System.out.println(validParenthesis.isValid(")([]{}"));
        System.out.println(validParenthesis.isValid("["));

    }

    public boolean isValid(String s) {
        List<String> openingBrackets = Arrays.asList("(", "{", "[");
        Map<String, String> b = new HashMap<>();
        b.put(")", "(");
        b.put("}", "{");
        b.put("]", "[");

        List<String> inputs = Arrays.asList(s.split(""));
        Stack<String> stack = new Stack<>();
        for (String i : inputs) {
            if (openingBrackets.contains(i)) {
                stack.push(i);
            } else if (!(!stack.isEmpty() && b.containsKey(i) && b.get(i).equals(stack.pop()))) {
                return false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }
}
