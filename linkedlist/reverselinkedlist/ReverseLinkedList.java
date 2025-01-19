package leetcode.linkedlist.reverselinkedlist;

import java.util.Arrays;
import java.util.List;

import leetcode.linkedlist.createlinkedlist.LinkedListCreator;
import leetcode.twonumbersaddionlinkedlist.ListNode;

/**
 * ReverseLinkedList
 */
public class ReverseLinkedList {

  private static ListNode reverseLinkedList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode previousNode = null;
    ListNode tempHead = head;
    ListNode nextNode = head.next;
    while (tempHead != null) {
      tempHead.next = previousNode;
      previousNode = tempHead;
      tempHead = nextNode;
      if (tempHead != null) {
        nextNode = tempHead.next;
      }
    }
    return previousNode;
  }

  public static void main(String[] args) {
    LinkedListCreator linkedListCreator = new LinkedListCreator();
    List<Integer> list = Arrays.asList(1, 9, 7, 0, 45);
    ListNode headNode = linkedListCreator.createLinkedList(list);
    linkedListCreator.printNode(headNode);
    System.out.println("----------------------");
    headNode = reverseLinkedList(headNode);
    linkedListCreator.printNode(headNode);

  }

}