package leetcode.stackandqueue.implement_stack_using_queue;

/**
 * ImplementStackUsingQueues
 */
public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(4);
        myStack.push(10);
        myStack.top(); // return 2
        myStack.pop(); // return 2
        myStack.empty(); // return False
    }
}
