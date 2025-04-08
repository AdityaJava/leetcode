package leetcode.stackandqueue.implement_queue_using_arrays;

/**
 * QueueUsingArrays
 */
public class QueueUsingArrays {
    public static void main(String[] args) {
        int[] arr =
            { 1, 78, 2, 2, 2, 1, 93, 2, 2, 1, 28, 1, 60, 2, 1, 41, 1, 73, 1, 12, 1, 68, 2, 1, 31, 1, 24, 2, 2, 2, 1, 23, 1, 70, 2, 2, 1, 12, 1, 30, 2, 2, 2, 1, 38, 1, 25, 2, 1, 14, 1, 92, 1, 57, 2, 1,
                71, 1, 82, 2, 2, 1, 28, 1, 6, 1, 30, 2, 2, 1, 96, 1, 46, 1, 68, 1, 65, 2, 1, 88, 1, 77, 1, 89, 1, 4, 2, 1, 100, 1, 61, 1, 69, 2, 1, 27, 1, 95, 2, 2, 1, 35, 1, 68, 2, 2, 1, 18, 1, 53,
                1, 2, 1, 87, 2, 2, 2, 1, 20, 1, 30, 2, 2, 2, 2, 2, 2, 2, 2 };
        //        int[] arr = { 1, 2, 1, 3, 2, 1, 4, 2 };
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < arr.length; i++) {
            if ((i + 1) < arr.length && arr[i] == 1) {
                myQueue.push(arr[++i]);
            }
            else if (arr[i] == 2) {
                System.out.println(myQueue.pop());
            }
        }
    }
}
