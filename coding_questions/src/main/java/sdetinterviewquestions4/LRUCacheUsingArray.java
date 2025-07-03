package sdetinterviewquestions4;

/**
 * Implementation of LRU (Least Recently Used) Cache using Arrays.
 * This implementation provides O(n) time complexity for both get and put operations.
 */
public class LRUCacheUsingArray {
    private int capacity;
    private int size;
    private int[] keys;
    private int[] values;
    private int[] timestamps;
    private int timeCounter;

    /**
     * Initializes the LRU Cache with the given capacity
     * @param capacity the maximum number of items the cache can hold
     */
    public LRUCacheUsingArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.keys = new int[capacity];
        this.values = new int[capacity];
        this.timestamps = new int[capacity];
        this.timeCounter = 0;
    }

    /**
     * Returns the value of the key if it exists, otherwise returns -1
     * @param key the key to look up
     * @return the value associated with the key, or -1 if not found
     */
    public int get(int key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                // Update the timestamp to mark as recently used
                timestamps[i] = ++timeCounter;
                return values[i];
            }
        }
        return -1; // Key not found
    }

    /**
     * Updates the value of the key if it exists, or adds the key-value pair to the cache.
     * If the cache is at capacity, removes the least recently used item first.
     * @param key the key to add or update
     * @param value the value to associate with the key
     */
    public void put(int key, int value) {
        // Check if key already exists
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                // Update value and timestamp
                values[i] = value;
                timestamps[i] = ++timeCounter;
                return;
            }
        }

        // If cache is full, remove least recently used item
        if (size == capacity) {
            int lruIndex = 0;
            int minTime = timestamps[0];
            
            for (int i = 1; i < size; i++) {
                if (timestamps[i] < minTime) {
                    minTime = timestamps[i];
                    lruIndex = i;
                }
            }
            
            // Shift elements to remove the LRU item
            for (int i = lruIndex; i < size - 1; i++) {
                keys[i] = keys[i + 1];
                values[i] = values[i + 1];
                timestamps[i] = timestamps[i + 1];
            }
            size--;
        }

        // Add new item
        keys[size] = key;
        values[size] = value;
        timestamps[size] = ++timeCounter;
        size++;
    }

    /**
     * Main method with test cases
     */
    public static void main(String[] args) {
        // Test Case 1: Basic operations
        System.out.println("Test Case 1: Basic operations");
        LRUCacheUsingArray cache = new LRUCacheUsingArray(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("Get 1: " + cache.get(1));  // returns 1
        
        // Test Case 2: Eviction of least recently used item
        System.out.println("\nTest Case 2: Eviction of LRU item");
        cache.put(3, 3);                   // evicts key 2
        System.out.println("Get 2: " + cache.get(2));  // returns -1 (not found)
        
        // Test Case 3: More operations after eviction
        System.out.println("\nTest Case 3: Operations after eviction");
        cache.put(4, 4);                   // evicts key 1
        System.out.println("Get 1: " + cache.get(1));  // returns -1 (not found)
        System.out.println("Get 3: " + cache.get(3));  // returns 3
        System.out.println("Get 4: " + cache.get(4));  // returns 4
    }
}
