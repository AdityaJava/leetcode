package leetcode.StackAndQueues.prefixInfixPostfix;

/**
 * InfixToPrefix
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Steps
 *
 * 1. Reverse the infix
 * 2. Change the opening to closing and closing to opening bracket
 * 2. Do Infix to Postfix
 * 3. Reverse the postfix
 */
public class InfixToPrefix {

  public String infixToPrefix(String s) {
    StringBuilder stringBuilder = new StringBuilder(s);
    String reverseInfix = stringBuilder.reverse().toString();
    reverseInfix = reverseInfix.replace(')', '?');
    reverseInfix = reverseInfix.replace('(', '>');
    reverseInfix = reverseInfix.replace('?', '(');
    reverseInfix = reverseInfix.replace('>', ')');
    String infixToPostFix = infixToPostFix(reverseInfix);
    stringBuilder = new StringBuilder(infixToPostFix);
    return stringBuilder.reverse().toString();
  }

  public String infixToPostFix(String s) {
    int i = 0;
    Stack<Character> stack = new Stack<>();
    StringBuilder result = new StringBuilder();
    while (i < s.length()) {
      Character temp = s.charAt(i);
      if (Character.isAlphabetic(temp) || Character.isDigit(temp)) {
        result.append(temp);
      }
      else {
        if (stack.isEmpty()) {
          stack.push(temp);
        }
        else if (temp == '(') {
          stack.push(temp);
        }
        else if (temp == ')') {
          Character top = stack.pop();
          while (top != '(') {
            result = result.append(top);
            top = stack.pop();
          }
        }
        else {
          Character top = stack.peek();
          //Only for operator ^ we need to check of priority greater than equals(This is exactly same ad infixToPostfix)
          //For other operators(in else part) we only check for lesser priority
          if (temp == '^') {
            while (!stack.isEmpty() && priority(top) >= priority(temp)) {
              result = result.append(stack.pop());
              if (!stack.isEmpty()) {
                top = stack.peek();
              }
            }
          }
          else {
            //The difference while we use this method for prefix is here
            // in infixToPostFix we do priority(top) >= priority(temp) that is the equal to is also there
            //But here it is not there
            while (!stack.isEmpty() && priority(top) > priority(temp)) {
              result = result.append(stack.pop());
              if (!stack.isEmpty()) {
                top = stack.peek();
              }
            }
          }
          stack.push(temp);
        }
      }

      i++;
    }
    while (!stack.isEmpty()) {
      result = result.append(stack.pop());
    }
    return result.toString();
  }

  private int priority(Character operator) {
    Map<Character, Integer> operatorToPriority = new HashMap<>();
    operatorToPriority.put('^', 3);
    operatorToPriority.put('*', 2);
    operatorToPriority.put('/', 2);
    operatorToPriority.put('+', 1);
    operatorToPriority.put('-', 1);
    operatorToPriority.put('(', 0);
    return operatorToPriority.get(operator);
  }

  public static void main(String[] args) {
    InfixToPrefix infixToPrefix = new InfixToPrefix();

    String s = "a+b*(c^d-e)^(f+g*h)-i";
    //    System.out.println(infixToPrefix.infixToPostFix(s));
    System.out.println(infixToPrefix.infixToPrefix(s));
  }
}
