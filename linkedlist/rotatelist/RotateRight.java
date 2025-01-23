package leetcode.linkedlist.rotatelist;

import java.util.Arrays;
import java.util.List;

import leetcode.linkedlist.createlinkedlist.LinkedListCreator;
import leetcode.twonumbersaddionlinkedlist.ListNode;

/**
 * RotateRight
 */
public class RotateRight {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode temp = head;
    int listSize = 1;
    while (temp.next != null) {
      temp = temp.next;
      listSize++;
    }
    temp.next = head;
    k = k % listSize;
    int count = listSize - k;
    int i = 1;
    temp = head;
    while (i < count) {
      temp = temp.next;
      i++;
    }
    head = temp.next;
    temp.next = null;
    return head;
  }

  public static void main(String[] args) {

    RotateRight rotateRight = new RotateRight();

    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    int k = 2;
    ListNode head = LinkedListCreator.createLinkedList(list);
    LinkedListCreator.printNode(head);
    System.out.println("-------------------");

    head = rotateRight.rotateRight(head, k);
    LinkedListCreator.printNode(head);

    //
    //    List<Integer> list = Arrays.asList(0, 1, 2);
    //    int k = 4;
    //    ListNode head = LinkedListCreator.createLinkedList(list);
    //    LinkedListCreator.printNode(head);
    //    System.out.println("-------------------");
    //
    //    head = rotateRight.rotateRight(head, k);
    //    LinkedListCreator.printNode(head);

  }
}
