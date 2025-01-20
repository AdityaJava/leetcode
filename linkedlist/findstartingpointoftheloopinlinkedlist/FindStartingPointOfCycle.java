package leetcode.linkedlist.findstartingpointoftheloopinlinkedlist;

import leetcode.twonumbersaddionlinkedlist.ListNode;

/**
 * LoopInLinkedList2
 */
public class FindStartingPointOfCycle {

  public static ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode slowPointer = head;
    ListNode fastPointer = head;
    boolean loopFound = false;
    while (fastPointer != null) {
      slowPointer = slowPointer.next;
      if (fastPointer == null || fastPointer.next == null) {
        loopFound = false;
        break;
      }
      fastPointer = fastPointer.next.next;
      if (fastPointer == slowPointer) {
        loopFound = true;
        break;
      }
    }
    if (loopFound) {
      ListNode tempHead = head;
      while (tempHead != slowPointer) {
        tempHead = tempHead.next;
        slowPointer = slowPointer.next;
      }
      return slowPointer;
    }
    return null;
  }

  public static void main(String[] args) {
    //    ListNode ls = new ListNode(3);
    //    ListNode ls1 = new ListNode(2);
    //    ls.next = ls1;
    //    ListNode ls2 = new ListNode(0);
    //    ls1.next = ls2;
    //    ListNode ls3 = new ListNode(4);
    //    ls2.next = ls3;
    //    ls3.next = ls1;
    //    System.out.println(detectCycle(ls).val);

    //    ListNode ls4 = new ListNode(1);
    //    ls4.next = null;
    //    ListNode node = detectCycle(ls4);
    //    if (node != null) {
    //      System.out.println(node.val);
    //    }

    ListNode ls5 = new ListNode(1);
    ListNode ls6 = new ListNode(2);
    ls5.next = ls6;
    ls6.next = null;
    ListNode node = detectCycle(ls5);
    if (node != null) {
      System.out.println(node.val);
    }

  }
}