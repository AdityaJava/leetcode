package leetcode.linkedlist.intersectionof2linkedlist;

import java.util.Arrays;
import java.util.List;

import leetcode.linkedlist.createlinkedlist.LinkedListCreator;
import leetcode.twonumbersaddionlinkedlist.ListNode;

/**
 * IntersectionOf2LinkedList
 */
public class IntersectionOf2LinkedList {

  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode dummy1 = headA;
    ListNode dummy2 = headB;
    while (dummy1 != dummy2) {
      dummy1 = dummy1 == null ? headB : dummy1.next;
      dummy2 = dummy2 == null ? headA : dummy2.next;
    }
    return dummy1;
  }

  public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList(1, 2);
    List<Integer> list2 = Arrays.asList(2, 8, 1, 3);
    List<Integer> intersectingList = Arrays.asList(8, 7, 6);
    List<ListNode> nodeList = LinkedListCreator.createIntersectingLinkedList(list1, list2, intersectingList);
    ListNode headA = nodeList.getFirst();
    ListNode headB = nodeList.get(1);
    ListNode intersectionNode = getIntersectionNode(headA, headB);
    System.out.println(intersectionNode != null ? intersectionNode.val : null);

    list1 = Arrays.asList(2, 6, 4);
    list2 = Arrays.asList(1, 5);
    intersectingList = null;
    nodeList = LinkedListCreator.createIntersectingLinkedList(list1, list2, intersectingList);
    headA = nodeList.getFirst();
    headB = nodeList.get(1);
    intersectionNode = getIntersectionNode(headA, headB);
    System.out.println(intersectionNode != null ? intersectionNode.val : null);
  }
}
