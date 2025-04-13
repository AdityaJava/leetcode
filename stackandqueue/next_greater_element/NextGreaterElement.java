package leetcode.stackandqueue.next_greater_element;

import java.util.Stack;

/**
 * NextGreaterElement
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums2.length];
        int ansPtr = nums2.length - 1;
        for (int i = nums2.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                ans[ansPtr--] = -1;
                stack.push(nums2[i]);
            }
            else if (nums2[i] < stack.peek()) {
                ans[ansPtr--] = stack.peek();
                stack.push(nums2[i]);
            }
            else if (nums2[i] >= stack.peek()) {
                while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                    stack.pop();
                }
                ans[ansPtr--] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(nums2[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums2 = new int[] { 4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6 };
        int[] nums1 = new int[0];

        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        int[] ans = nextGreaterElement.nextGreaterElement(nums1, nums2);

        for (int a : ans) {
            System.out.println(a);
        }
    }
}
