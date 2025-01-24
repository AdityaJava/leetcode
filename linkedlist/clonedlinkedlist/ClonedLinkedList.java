package leetcode.linkedlist.clonedlinkedlist;

/**
 * ClonedLinkedList
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Algo
 * 1. Insert copy nodes in between
 * 2. Connect random nodes
 * 3. Connect next pointers
 */
public class ClonedLinkedList {

  public static Node copyRandomList(Node head) {

    Node temp = head;
    Node copyTemp = null;
    // 1. Insert copy nodes in between
    while (temp != null) {
      copyTemp = new Node(temp.val);
      copyTemp.next = temp.next;
      temp.next = copyTemp;
      temp = temp.next.next;
    }
    temp = head;

    //2. Connect random nodes
    while (temp != null) {
      if (temp.random != null) {
        temp.next.random = temp.random.next;
      }
      else {
        temp.next.random = null;
      }
      temp = temp.next.next;
    }

    //3. Connect next pointers
    Node dummyNode = new Node(-1);
    Node res = dummyNode;
    temp = head;
    while (temp != null) {
      res.next = temp.next;
      res = res.next;
      if (temp.next != null) {
        temp.next = temp.next.next;
      }
      else {
        temp.next = null;
      }
      temp = temp.next;
    }

    return dummyNode.next;
  }

  public static Node createLinkedListWithRandomPointer(Map<Integer, Integer> nodeToRandomPointerIndex) {
    Node head = null;
    Node temp = null;
    Node node = null;
    int count = 0;
    Map<Integer, Node> indexToNode = new HashMap<>();
    Iterator<Map.Entry<Integer, Integer>> nodeToRandomPointerIndexIterator = nodeToRandomPointerIndex.entrySet().iterator();
    while (nodeToRandomPointerIndexIterator.hasNext()) {
      int number = nodeToRandomPointerIndexIterator.next().getKey();
      node = new Node(number);
      if (head == null) {
        head = node;
        temp = head;
      }
      else {
        temp.next = node;
        temp = temp.next;
      }
      indexToNode.put(count, temp);
      count++;
    }
    temp = head;
    nodeToRandomPointerIndexIterator = nodeToRandomPointerIndex.entrySet().iterator();
    while (nodeToRandomPointerIndexIterator.hasNext()) {
      Integer randomIndex = nodeToRandomPointerIndexIterator.next().getValue();
      if (randomIndex == null) {
        temp.random = null;
      }
      else {
        temp.random = indexToNode.get(randomIndex);
      }
      temp = temp.next;
    }
    return head;
  }

  public static void main(String[] args) {
    Map<Integer, Integer> nodeToRandomPointerIndex = new LinkedHashMap<>();
    nodeToRandomPointerIndex.put(7, null);
    nodeToRandomPointerIndex.put(13, 0);
    nodeToRandomPointerIndex.put(11, 4);
    nodeToRandomPointerIndex.put(10, 2);
    nodeToRandomPointerIndex.put(1, 0);
    Node head = createLinkedListWithRandomPointer(nodeToRandomPointerIndex);
    head = copyRandomList(head);
  }
}
