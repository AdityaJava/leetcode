package leetcode.stackandqueuepart2.LFUCache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * LFUCache
 */
public class LFUCache {
    int capacity;
    List<LRUCacheForLFUCache> lruCacheList;
    Map<Integer, List<LRUCacheForLFUCache>> frequencyToLRUCache;
    int leastFrequency;
    Map<Integer, DLLNode> keyToNodeAddress;

    LFUCache(int capacity) {
        this.capacity = capacity;
        lruCacheList = new ArrayList<>();
    }

    public int get(int key) {
        if (!keyToNodeAddress.containsKey(key)) {
            return -1;
        }
        else {
            DLLNode dllNode = keyToNodeAddress.get(key);
            insertInFrequency(dllNode, dllNode.frequency + 1);
            return dllNode.value;
        }
    }

    public void put(int key, int value) {
        if (keyToNodeAddress.containsKey(key)) {
            DLLNode dllNode = keyToNodeAddress.get(key);
            dllNode.value = value;
            insertInFrequency(dllNode, dllNode.frequency + 1);
        }
        else {
            DLLNode dllNode = new DLLNode(key, value, 0);
            insertInFrequency(dllNode, 0);
        }
    }

    private void insertInFrequency(DLLNode dllNode, int nextFrequency) {

        dllNode.frequency = nextFrequency;
        if (lruCacheList.size() < nextFrequency || nextFrequency == 0) {
            lruCacheList.add(new LRUCacheForLFUCache(capacity, keyToNodeAddress));
        }
        LRUCacheForLFUCache nextFreqLruCache = lruCacheList.get(nextFrequency);
        nextFreqLruCache.insertAfterHead(dllNode);
    }

    private void delete(DLLNode dllNode) {
        LRUCacheForLFUCache lruCache = lruCacheList.get(dllNode.frequency);
        //delete from old frequency list
        lruCache.delete(dllNode);

    }

}
