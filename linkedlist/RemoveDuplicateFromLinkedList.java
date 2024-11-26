package leetcode.linkedlist;

import leetcode.twonumbersaddionlinkedlist.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class RemoveDuplicateFromLinkedList {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode temp = head;
        ListNode curr = head;
        while(curr!=null){

            while(temp!=null && curr.val == temp.val ){
                temp = temp.next;
            }
            curr.next = temp;
            curr = curr.next;
        }
        return head;

    }
}