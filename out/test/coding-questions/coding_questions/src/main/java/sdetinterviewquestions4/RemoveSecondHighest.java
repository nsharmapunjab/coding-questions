package sdetinterviewquestions4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RemoveSecondHighest {

    public static void main(String[] args) {
        // Sample HashMap
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 85);
        scores.put("Bob", 92);
        scores.put("Charlie", 88);
        scores.put("David", 95);
        scores.put("Eve", 90);

        System.out.println("Original Map: " + scores);

        removeSecondHighest(scores);

        System.out.println("Map After Removing Second Highest: " + scores);
    }

    public static void removeSecondHighest(Map<String, Integer> map) {
        if (map.size() < 2) {
            System.out.println("Not enough elements to remove second highest.");
            return;
        }

        // Extract and sort unique values in descending order
        List<Integer> uniqueValues = new ArrayList<>(new HashSet<>(map.values()));
        Collections.sort(uniqueValues, Collections.reverseOrder());

        if (uniqueValues.size() < 2) {
            System.out.println("No distinct second highest value to remove.");
            return;
        }

        int secondHighest = uniqueValues.get(1); // second highest

        // Remove entries with this second highest value
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue() == secondHighest) {
                iterator.remove();
            }
        }

        System.out.println("Removed entries with value: " + secondHighest);
    }
}
