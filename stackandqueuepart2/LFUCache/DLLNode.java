package leetcode.stackandqueuepart2.LFUCache;

/**
 * DLLNode
 */
public class DLLNode {
    int key, value;
    int frequency;
    DLLNode next;
    DLLNode previous;

    public DLLNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public DLLNode(int key, int value, int frequency) {
        this.key = key;
        this.value = value;
        this.frequency = frequency;
        this.next = null;
        this.previous = null;
    }

    public DLLNode() {

    }
}
