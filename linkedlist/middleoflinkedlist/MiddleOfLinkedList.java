package leetcode.linkedlist.middleoflinkedlist;

import java.util.Arrays;
import java.util.List;

import leetcode.linkedlist.createlinkedlist.LinkedListCreator;
import leetcode.twonumbersaddionlinkedlist.ListNode;

/**
 * MiddleOfLinkedList
 *
 * Maxxton Group 2025
 *
 * @author a.dudhal (a.dudhal@maxxton.com)
 */
public class MiddleOfLinkedList {

  public static ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public static void main(String[] args) {
    LinkedListCreator linkedListCreator = new LinkedListCreator();
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    ListNode headNode = linkedListCreator.createLinkedList(list);
    headNode = middleNode(headNode);
    linkedListCreator.printNode(headNode);
  }
}
