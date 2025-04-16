package leetcode.stackandqueuepart2.LFUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * LRUCacheForLFUCache
 */
public class LRUCacheForLFUCache {
    DLLNode head, tail;
    Map<Integer, DLLNode> keyToNodeAddress;
    int capacity;

    public LRUCacheForLFUCache(int lfuCacheCapacity, Map<Integer, DLLNode> keyToNodeAddress) {
        head = new DLLNode();
        tail = new DLLNode();
        head.next = tail;
        tail.previous = head;
        this.keyToNodeAddress = keyToNodeAddress == null ? new HashMap<>() : keyToNodeAddress;
        capacity = lfuCacheCapacity;
    }

    public int get(int key) {
        if (!keyToNodeAddress.containsKey(key)) {
            return -1;
        }
        DLLNode dllNode = keyToNodeAddress.get(key);
        delete(dllNode);
        insertAfterHead(dllNode);
        return keyToNodeAddress.get(key).value;
    }

    public void put(int key, int value) {
        if (keyToNodeAddress.containsKey(key)) {
            DLLNode dllNode = keyToNodeAddress.get(key);
            dllNode.value = value;
            delete(dllNode);
            insertAfterHead(dllNode);
        }
        else {
            if (capacity == keyToNodeAddress.size()) {
                delete(tail.previous);
            }
            insertAfterHead(new DLLNode(key, value));
        }
    }

    public void insertAfterHead(DLLNode dllNode) {
        keyToNodeAddress.put(dllNode.key, dllNode);

        DLLNode headNext = head.next;

        head.next = dllNode;
        dllNode.previous = head;

        dllNode.next = headNext;
        headNext.previous = dllNode;
    }

    public void delete(DLLNode dllNode) {
        keyToNodeAddress.remove(dllNode.key);
        dllNode.previous.next = dllNode.next;
        dllNode.next.previous = dllNode.previous;
    }
}
