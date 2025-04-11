package leetcode.stackandqueue.check_for_balanced_paranthesis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * BalancedParanthesis
 */
public class BalancedParanthesis {

    public boolean isValid(String s) {
        Map<Character, Character> openingToClosingBrackets = new HashMap<>();
        openingToClosingBrackets.put('(', ')');
        openingToClosingBrackets.put('{', '}');
        openingToClosingBrackets.put('[', ']');
        Set<Character> openingBrackets = openingToClosingBrackets.keySet();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (openingBrackets.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character openingBracket = stack.pop();
                if (!openingToClosingBrackets.get(openingBracket).equals(s.charAt(i))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        //        String s = "()[]{}";
        String s = "}";

        BalancedParanthesis balancedParanthesis = new BalancedParanthesis();
        System.out.println(balancedParanthesis.isValid(s));
    }
}
