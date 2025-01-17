package leetcode.linkedlist.remove_nth_node_from_end;

import leetcode.linkedlist.createlinkedlist.LinkedListCreator;
import leetcode.twonumbersaddionlinkedlist.ListNode;

import java.util.Arrays;
import java.util.List;

public class RemoveNthNodeFromEndOfLinkedList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fastPointer = dummy, slowPointer = dummy;
        int i = 0;
        while (fastPointer.next != null) {
            for (; i < n; i++) {
                fastPointer = fastPointer.next;
            }
            if (fastPointer.next != null) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }
        }
        slowPointer.next = slowPointer.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedListCreator linkedListCreator = new LinkedListCreator();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        ListNode headNode = linkedListCreator.createLinkedList(list);
        LinkedListCreator.printNode(headNode);
        RemoveNthNodeFromEndOfLinkedList removeNthNodeFromEndOfLinkedList = new RemoveNthNodeFromEndOfLinkedList();

        System.out.println("");
        int n = 5;
        headNode = removeNthNodeFromEndOfLinkedList.removeNthFromEnd(headNode, n);
        LinkedListCreator.printNode(headNode);

//        System.out.println("");
//        n = 4;
//        headNode = removeNthNodeFromEndOfLinkedList.removeNthFromEnd(headNode, n);
//        LinkedListCreator.printNode(headNode);
    }
}
