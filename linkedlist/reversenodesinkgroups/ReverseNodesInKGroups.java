package leetcode.linkedlist.reversenodesinkgroups;

import java.util.Arrays;
import java.util.List;

import leetcode.linkedlist.createlinkedlist.LinkedListCreator;
import leetcode.twonumbersaddionlinkedlist.ListNode;

/**
 * ReverseNodesInKGroups
 */
public class ReverseNodesInKGroups {

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k <= 1) {
      return head;
    }

    ListNode temp = head;
    ListNode prevLast = null;
    boolean isFirstChunk = true;
    ListNode newHead = null;
    int numberOfElements = getNumberOfElements(head);
    int count = numberOfElements;

    while (temp != null) {
      if (count < k) {
        if (prevLast != null) {
          prevLast.next = temp;
        }
        break;
      }
      ListNode kthNode = getKthNode(temp, k);
      ListNode nextNode = kthNode.next;
      kthNode.next = null;
      if (isFirstChunk) {
        newHead = kthNode;
        isFirstChunk = false;
      }
      reverseLinkedList(temp);
      if (prevLast != null) {
        prevLast.next = kthNode;
      }
      prevLast = temp;
      temp = nextNode;
      count = count - k;
    }
    return newHead;
  }

  private ListNode reverseLinkedList(ListNode head) {
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

  private ListNode getKthNode(ListNode start, int k) {
    ListNode temp = start;
    int i = 1;
    while (temp.next != null && i < k) {
      temp = temp.next;
      i++;
    }
    return temp;
  }

  private int getNumberOfElements(ListNode head) {
    ListNode temp = head;
    int count = 0;
    while (temp != null) {
      temp = temp.next;
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    ListNode headNode = LinkedListCreator.createLinkedList(list);
    int k = 3;
    ReverseNodesInKGroups reverseNodesInKGroups = new ReverseNodesInKGroups();
    ListNode newHead = reverseNodesInKGroups.reverseKGroup(headNode, k);
    LinkedListCreator.printNode(newHead);
  }
}
