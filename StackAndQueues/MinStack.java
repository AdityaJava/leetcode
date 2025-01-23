package leetcode.StackAndQueues;

import java.util.Stack;

/**
 * ImplementMinStack
 */
public class MinStack {
  Stack<Integer> stack;
  Integer minimum = 0;

  public MinStack() {
    stack = new Stack<>();
  }

  // Preserve the prev min by using below formula
  // 2*val - prevMinimun = newVal
  public void push(int val) {
    if (stack.isEmpty()) {
      stack.push(val);
      minimum = val;
    }
    else {
      if (val > minimum) {
        stack.push(val);
      }
      else {
        int valToPush = 2 * val - minimum;
        stack.push(valToPush);
        minimum = val;
      }
    }
  }

  //Here remember that minimum was the val came in push operation
  public void pop() {
    if (stack.isEmpty()) {
      return;
    }
    else {
      int valPushed = top();
      stack.pop();
      if (valPushed < minimum) {
        minimum = 2 * minimum - valPushed;
      }
    }
  }

  public int top() {
    if (stack.isEmpty()) {
      return 0;
    }
    int top = stack.peek();
    if (top < minimum) {
      return minimum;
    }
    return top;
  }

  public int getMin() {
    return minimum;
  }
}
