package leetcode.stackandqueue.next_greater_element;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * NextGreaterElement
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] nextGreater = new int[nums2.length];
        int[] ans = new int[nums1.length];
        Map<Integer, Integer> elementToNextGreater = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                elementToNextGreater.put(nums2[i], -1);
                stack.push(nums2[i]);
            }
            else if (nums2[i] < stack.peek()) {
                elementToNextGreater.put(nums2[i], stack.peek());
                stack.push(nums2[i]);
            }
            else if (nums2[i] >= stack.peek()) {
                while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                    stack.pop();
                }
                elementToNextGreater.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
                stack.push(nums2[i]);
            }
        }
        int i = 0;
        for (int n : nums1) {
            ans[i++] = elementToNextGreater.get(n);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums2 = new int[] { 1, 3, 4, 2 };
        int[] nums1 = new int[] { 4, 1, 2 };

        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        int[] ans = nextGreaterElement.nextGreaterElement(nums1, nums2);

        for (int a : ans) {
            System.out.println(a);
        }
    }
}
