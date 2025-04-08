package leetcode.stackandqueue.implement_queue_using_arrays;

class MyQueue {

    int front, rear;
    int arr[] = new int[100005];
    int currentSize;
    int maxSize = arr.length - 1;

    MyQueue() {
        front = -1;
        rear = -1;
        currentSize = 0;
    }

    //Function to push an element x in a queue.
    void push(int x) {
        if (rear == -1) {
            front = 0;
            rear = 0;
        }
        else {
            rear = (rear + 1) % maxSize;
        }
        arr[rear] = x;
        currentSize++;
    }

    //Function to pop an element from queue and return that element.
    int pop() {
        if (front == -1) {
            return -1;
        }
        int popped = arr[front];
        if (currentSize == 0) {
            return -1;
        }
        if (currentSize == 1) {
            front = -1;
            rear = -1;
        }
        else {
            front = (front + 1) % maxSize;
        }
        currentSize--;
        return popped;
    }
}
