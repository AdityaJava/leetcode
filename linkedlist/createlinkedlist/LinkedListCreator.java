package leetcode.linkedlist.createlinkedlist;

import java.util.List;

import leetcode.twonumbersaddionlinkedlist.ListNode;

/**
 * LinkedListCreator
 *
 * Maxxton Group 2025
 *
 * @author a.dudhal (a.dudhal@maxxton.com)
 */
public class LinkedListCreator {
  public static ListNode createLinkedList(List<Integer> list) {
    ListNode head = null;
    ListNode temp = null;
    for (Integer i : list) {
      if (head == null) {
        head = new ListNode(i);
        temp = head;
      }
      else {
        temp.next = new ListNode(i);
        temp = temp.next;
      }
    }
    return head;
  }

  public static void printNode(ListNode headNode) {
    ListNode temp = headNode;
    while (temp != null) {
      System.out.print(temp.val + "->");
      temp = temp.next;
    }
  }

}
