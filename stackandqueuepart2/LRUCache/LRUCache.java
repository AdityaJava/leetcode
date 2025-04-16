package leetcode.stackandqueuepart2.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * LRUCache
 */
class Node {
    int key, value;
    Node prev;
    Node next;

    Node() {
        prev = null;
        next = null;
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    Node head, tail;
    Map<Integer, Node> keyToAddress;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        keyToAddress = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToAddress.containsKey(key)) {
            return -1;
        }
        Node node = keyToAddress.get(key);
        this.deleteNode(node);
        this.insertNodeAfterHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (keyToAddress.containsKey(key)) {
            Node node = keyToAddress.get(key);
            node.value = value;
            deleteNode(node);
            insertNodeAfterHead(node);
        }
        else {
            if (capacity == keyToAddress.size()) {
                deleteNode(tail.prev);
            }
            insertNodeAfterHead(new Node(key, value));
        }
    }

    private void insertNodeAfterHead(Node node) {
        Node currentHeadNext = this.head.next;
        keyToAddress.put(node.key, node);

        this.head.next = node;
        node.prev = this.head;

        node.next = currentHeadNext;
        currentHeadNext.prev = node;
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        keyToAddress.remove(node.key);
    }
}
