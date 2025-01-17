package leetcode.linkedlist.deletenode;

import leetcode.twonumbersaddionlinkedlist.ListNode;

/**
 * NodeDeletor
 */
public class NodeDeletor {
  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }

}
