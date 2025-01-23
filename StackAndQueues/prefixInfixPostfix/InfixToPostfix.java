package leetcode.StackAndQueues.prefixInfixPostfix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/*
Here’s a short summary of the **infix to postfix** conversion steps:
1. Operands: Add directly to the output.
2. Operators:
   - Pop from the stack to the output while the top of the stack has **higher or equal precedence**.
   - Then, push the current operator onto the stack.
3. Left Parenthesis `(`: Push onto the stack.
4. Right Parenthesis `)`:
   - Pop from the stack to the output until a left parenthesis `(` is encountered.
   - Discard the `(`.
5. End: Pop remaining operators from the stack to the output.
*/

/**
 * InfixToPostfix
 */
public class InfixToPostfix {

  public static String infixToPostfix(String s) {
    int i = 0;
    List<String> stringList = Arrays.asList(s.split(""));
    Stack<Character> stack = new Stack<>();
    StringBuilder result = new StringBuilder();
    while (i < s.length()) {
      Character temp = s.charAt(i);
      if (Character.isAlphabetic(temp) || Character.isDigit(temp)) {
        result = result.append(stringList.get(i));
      }
      else {
        if (stack.isEmpty()) {
          stack.push(temp);
        }
        else if (temp == '(') {
          stack.push('(');
        }
        else if (temp == ')') {
          Character top = stack.pop();
          while (!stack.isEmpty() && top != '(') {
            result = result.append(top);
            top = stack.pop();
          }
        }
        else {
          Character top = stack.peek();
          while (!stack.isEmpty() && priority(top) >= priority(temp)) {
            result = result.append(stack.pop());
            if (!stack.isEmpty()) {
              top = stack.peek();
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

  private static int priority(Character operator) {
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
    String s = "a+b*(c^d-e)^(f+g*h)-i";
    System.out.println(InfixToPostfix.infixToPostfix(s));
  }
}
