package leetcode.linkedlist.createlinkedlist;

import java.util.Arrays;
import java.util.List;

import leetcode.twonumbersaddionlinkedlist.ListNode;

/**
 * LinkedListCreator
 */
public class LinkedListCreator {

  public static ListNode createLinkedList(List<Integer> list) {
    if (list == null) {
      return null;
    }
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

  public static ListNode getLastNode(ListNode head) {
    ListNode temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    return temp;
  }

  public static List<ListNode> createIntersectingLinkedList(List<Integer> list1, List<Integer> list2, List<Integer> intersectingList) {
    ListNode head1 = createLinkedList(list1);
    ListNode head2 = createLinkedList(list2);
    ListNode head3 = createLinkedList(intersectingList);
    ListNode lastNode1 = getLastNode(head1);
    ListNode lastNode2 = getLastNode(head2);
    lastNode1.next = head3;
    lastNode2.next = head3;
    return Arrays.asList(head1, head2);
  }

  public static void printNode(ListNode headNode) {
    ListNode temp = headNode;
    while (temp != null) {
      System.out.print(temp.val + "->");
      temp = temp.next;
    }
  }


}
