package sdetinterviewquestions4;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    public static Character findFirstNonRepeating(String s) {
        if (s == null || s.isEmpty()) return null;

        // Step 1: Count character frequencies
        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Find first character with count == 1
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null; // No non-repeating character found
    }

    public static void main(String[] args) {
        String input = "swiss";
        Character result = findFirstNonRepeating(input);
        if (result != null) {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}
