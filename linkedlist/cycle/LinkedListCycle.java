package leetcode.linkedlist.cycle;

import leetcode.twonumbersaddionlinkedlist.ListNode;

/**
 * LinkedListCycle
 */
public class LinkedListCycle {

  public static boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null) {
      slow = slow.next;
      if (fast == null || fast.next == null) {
        return false;
      }
      fast = fast.next.next;
      if (fast == slow) {
        return true;
      }
    }
    return false;
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
    //    System.out.println(hasCycle(ls));

    //    ListNode ls4 = new ListNode(1);
    //    ListNode ls5 = new ListNode(2);
    //    ls4.next = ls5;
    //    ls5.next = ls4;
    //    System.out.println(hasCycle(ls4));

    ListNode ls4 = new ListNode(1);
    ls4.next = null;
    System.out.println(hasCycle(ls4));
  }
}
