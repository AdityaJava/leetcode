package leetcode.linkedlist.createlinkedlist;

import java.util.List;

import leetcode.linkedlist.Node;

/**
 * MultiDimensionalLinkedListCreator
 */
public class MultiDimensionalLinkedListCreator {

  public static Node createMultiDLinkedList(List<List<Integer>> multiDList) {
    Node prev = null;
    Node root = null;
    for (List<Integer> list : multiDList) {
      Node node = createBottomLinkedList(list);
      if (prev != null) {
        prev.next = node;
      }
      if (root == null) {
        root = node;
      }
      prev = node;
    }
    return root;
  }

  public static Node createBottomLinkedList(List<Integer> integers) {
    Node temp = null;
    Node head = null;
    for (int i : integers) {
      if (head == null) {
        head = new Node(i);
        temp = head;
      }
      else {
        Node node = new Node(i);
        temp.bottom = node;
        temp = temp.bottom;
      }
    }
    return head;
  }

}
