package leetcode.linkedlist.flatteninglinkedlist;

import java.util.Arrays;
import java.util.List;

import leetcode.linkedlist.Node;
import leetcode.linkedlist.createlinkedlist.MultiDimensionalLinkedListCreator;

/**
 * FlattenLinkedList
 */
public class FlattenLinkedList {

  public Node merge2SortedLinkedList(Node headA, Node headB) {
    Node temp = new Node(1);
    Node head = temp;
    Node d1 = headA, d2 = headB;
    while (d1 != null && d2 != null) {
      if (d1.data <= d2.data) {
        temp.bottom = d1;
        temp = temp.bottom;
        d1 = d1.bottom;
      }
      else {
        temp.bottom = d2;
        temp = temp.bottom;
        d2 = d2.bottom;
      }
    }
    if (d1 != null) {
      temp.bottom = d1;
    }
    else {
      temp.bottom = d2;
    }
    return head.bottom;
  }

  Node flatten(Node root) {
    return flattenRecursively(root);
  }

  private Node flattenRecursively(Node head) {
    if (head == null || head.next == null) {
      return head;
    }
    //recursion for list in right
    head.next = flattenRecursively(head.next);

    //now merge
    head = merge2SortedLinkedList(head, head.next);

    //return the root
    //it will be in turn merged with it's left
    return head;
  }

  public static void main(String[] args) {
    List<List<Integer>> multiDList = Arrays.asList(Arrays.asList(5, 7, 8, 30), Arrays.asList(10, 20), Arrays.asList(19, 22, 50), Arrays.asList(28, 35, 40, 45));
    Node root = MultiDimensionalLinkedListCreator.createMultiDLinkedList(multiDList);
    System.out.println("asd");

  }
}
