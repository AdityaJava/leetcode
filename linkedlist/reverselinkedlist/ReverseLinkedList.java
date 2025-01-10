package leetcode.linkedlist.reverselinkedlist;

import java.util.Arrays;
import java.util.List;

import leetcode.linkedlist.createlinkedlist.LinkedListCreator;
import leetcode.twonumbersaddionlinkedlist.ListNode;

/**
 * ReverseLinkedList
 */
public class ReverseLinkedList {

  public static ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode temp = null;
    ListNode next = head.next;
    while (head != null) {
      head.next = temp;
      temp = head;
      head = next;
      if (head != null) {
        next = head.next;
      }
    }
    return temp;
  }

  public static void main(String[] args) {
    LinkedListCreator linkedListCreator = new LinkedListCreator();
    List<Integer> list = Arrays.asList(1, 9, 7, 0, 45);
    ListNode headNode = linkedListCreator.createLinkedList(list);
    linkedListCreator.printNode(headNode);
    headNode = reverseList(headNode);
    linkedListCreator.printNode(headNode);
  }

}