package sdetinterviewquestions4;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {

    public static void main(String[] args) {
        // Create TreeMap instance
        TreeMap<Integer, String> map = new TreeMap<>();

        // Add entries
        map.put(101, "Apple");
        map.put(105, "Mango");
        map.put(103, "Banana");
        map.put(102, "Grapes");
        map.put(104, "Orange");

        // Print all elements (automatically sorted by key)
        System.out.println("TreeMap Elements:");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + "  →  Value: " + entry.getValue());
        }
    }
}
