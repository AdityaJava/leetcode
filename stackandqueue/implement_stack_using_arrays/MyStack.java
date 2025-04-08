package leetcode.stackandqueue.implement_stack_using_arrays;

class MyStack {
    private int[] arr;
    private int top;

    public MyStack() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        top++;
        if (top <= 1000) {
            arr[top] = x;
        }
    }

    public int pop() {
        if (top >= 0) {
            int x = arr[top];
            top--;
            return x;
        }
        return -1;
    }
}
