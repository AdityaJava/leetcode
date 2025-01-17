package leetcode.linkedlist.add_two_numbers;

import leetcode.linkedlist.createlinkedlist.LinkedListCreator;
import leetcode.twonumbersaddionlinkedlist.ListNode;

import java.util.Arrays;
import java.util.List;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newList = null;
        ListNode temp = new ListNode();
        ListNode head = temp;
        temp.val = 0;
        int sum = 0;
        int carry = 0;
        int nodeVal = 0;
        while (l1 != null || l2 != null || carry != 0) {
            sum = 0;
            newList = new ListNode();
            if (l1 != null) {
                sum = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }
            sum = sum + carry;
            nodeVal = sum % 10;
            carry = sum / 10;
            newList.val = nodeVal;
            temp.next = newList;
            temp = temp.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(9, 9, 9, 9, 9, 9, 9);
        List<Integer> list2 = Arrays.asList(9, 9, 9, 9);
        ListNode head1 = LinkedListCreator.createLinkedList(list);
        ListNode head2 = LinkedListCreator.createLinkedList(list2);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode head3 = addTwoNumbers.addTwoNumbers(head1, head2);
        LinkedListCreator.printNode(head3);
    }
}
