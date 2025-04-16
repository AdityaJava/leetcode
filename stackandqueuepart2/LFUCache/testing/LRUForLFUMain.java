package leetcode.stackandqueuepart2.LFUCache.testing;

import leetcode.stackandqueuepart2.LFUCache.LRUCacheForLFUCache;

/**
 * LRUForLFUMain
 */
public class LRUForLFUMain {
    public static void main(String[] args) {
        LRUCacheForLFUCache lruCacheForLFUCache = new LRUCacheForLFUCache(2, null);
        lruCacheForLFUCache.put(1, 1); // cache is {1=1}
        lruCacheForLFUCache.put(2, 2); // cache is {1=1, 2=2}
        lruCacheForLFUCache.get(1);    // return 1
        lruCacheForLFUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lruCacheForLFUCache.get(2);    // returns -1 (not found)
        lruCacheForLFUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lruCacheForLFUCache.get(1);    // return -1 (not found)
        lruCacheForLFUCache.get(3);    // return 3
        lruCacheForLFUCache.get(4);    // return 4
    }
}
