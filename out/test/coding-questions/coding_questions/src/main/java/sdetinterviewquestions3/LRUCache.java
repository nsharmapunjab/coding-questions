package sdetinterviewquestions3;

import java.util.HashMap;

public class LRUCache<K, V> {
    private final int capacity;
    private final HashMap<K, Node> cache;
    private final Node head, tail;

    private class Node {
        K key;
        V value;
        Node prev, next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // Dummy head and tail for easier list handling
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        if (!cache.containsKey(key)) return null;

        Node node = cache.get(key);
        moveToFront(node);
        return node.value;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            Node existing = cache.get(key);
            existing.value = value;
            moveToFront(existing);
        } else {
            if (cache.size() == capacity) {
                // Remove LRU item
                Node lru = tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToFront(newNode);
        }
    }

    // Doubly linked list operations
    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }

    private void addToFront(Node node) {
        Node first = head.next;
        head.next = node;
        node.prev = head;
        node.next = first;
        first.prev = node;
    }

    private void removeNode(Node node) {
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
    }

    // Debug method
    public void printCacheState() {
        Node current = head.next;
        System.out.print("Cache state: ");
        while (current != tail) {
            System.out.print("[" + current.key + ":" + current.value + "] ");
            current = current.next;
        }
        System.out.println();
    }
        
    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(3);
    
        cache.put("A", "Apple");
        cache.put("B", "Banana");
        cache.put("C", "Cherry");
        cache.printCacheState(); // A, B, C
    
        cache.get("A"); // A becomes most recently used
        cache.put("D", "Date"); // B is least recently used and should be evicted
    
        cache.printCacheState(); // C, A, D
    
        System.out.println("Get A: " + cache.get("A")); // Apple
        System.out.println("Get B: " + cache.get("B")); // null (evicted)
    }
}