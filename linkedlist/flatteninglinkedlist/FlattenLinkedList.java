package leetcode.linkedlist.flatteninglinkedlist;

import java.util.Arrays;
import java.util.List;

import leetcode.linkedlist.Node;
import leetcode.linkedlist.createlinkedlist.MultiDimensionalLinkedListCreator;

/**
 * FlattenLinkedList
 */
public class FlattenLinkedList {

  public static void main(String[] args) {
    List<List<Integer>> multiDList = Arrays.asList(Arrays.asList(5, 7, 8, 30), Arrays.asList(10, 20), Arrays.asList(19, 22, 50), Arrays.asList(28, 35, 40, 45));
    Node root = MultiDimensionalLinkedListCreator.createMultiDLinkedList(multiDList);
    System.out.println("asd");
  }
}
