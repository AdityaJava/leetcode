package leetcode.linkedlist.checkforpalindromiclinkedlist;

import java.util.Arrays;
import java.util.List;

import leetcode.linkedlist.createlinkedlist.LinkedListCreator;
import leetcode.twonumbersaddionlinkedlist.ListNode;

/**
 * CheckForPalindromicLinkedList
 */
public class CheckForPalindromicLinkedList {

  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    ListNode slowPointer = head;
    ListNode fastPointer = head;
    while (fastPointer.next != null && fastPointer.next.next != null) {
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next.next;
    }
    ListNode rightNewHead = reverseLinkedList(slowPointer.next);
    slowPointer.next = rightNewHead;
    slowPointer = slowPointer.next;
    ListNode tempHead = head;
    while (slowPointer != null) {
      if (slowPointer.val == tempHead.val) {
        slowPointer = slowPointer.next;
        tempHead = tempHead.next;
      }
      else {
        return false;
      }
    }
    return true;
  }

  private ListNode reverseLinkedList(ListNode head) {
    ListNode prev = null;
    ListNode tempNode = head;
    ListNode nextNode = head.next;
    while (tempNode != null) {
      tempNode.next = prev;
      prev = tempNode;
      tempNode = nextNode;
      if (tempNode != null) {
        nextNode = tempNode.next;
      }
    }
    return prev;
  }

  public static void main(String[] args) {
    CheckForPalindromicLinkedList checkForPalindromicLinkedList = new CheckForPalindromicLinkedList();
    List<Integer> list = Arrays.asList(1, 2, 2, 1);
    ListNode headNode = LinkedListCreator.createLinkedList(list);
    System.out.println(checkForPalindromicLinkedList.isPalindrome(headNode));

    List<Integer> list1 = Arrays.asList(1, 2);
    ListNode headNode1 = LinkedListCreator.createLinkedList(list1);
    System.out.println(checkForPalindromicLinkedList.isPalindrome(headNode1));

    List<Integer> list2 = Arrays.asList(1);
    ListNode headNode2 = LinkedListCreator.createLinkedList(list2);
    System.out.println(checkForPalindromicLinkedList.isPalindrome(headNode2));
  }
}
