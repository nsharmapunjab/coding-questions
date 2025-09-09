package sdetinterviewquestions4;

import java.util.HashMap;
import java.util.Map;

public class LargestNonDupNumber {
    
    public static int findLargestNonDuplicate(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // or throw an exception based on requirements
        }
        
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxNonDup = Integer.MIN_VALUE;
        
        // Count frequency of each number
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Find the maximum number that appears exactly once
        for (int num : arr) {
            if (frequencyMap.get(num) == 1 && num > maxNonDup) {
                maxNonDup = num;
            }
        }
        
        return maxNonDup == Integer.MIN_VALUE ? -1 : maxNonDup; // Return -1 if no non-duplicate found
    }
    
    public static void main(String[] args) {
        // Test case
        int[] arr = {4, 3, 2, 7, 3, 4, 8};
        int result = findLargestNonDuplicate(arr);
        System.out.println("Input array: [4, 3, 2, 7, 3, 4, 8]");
        System.out.println("Largest non-duplicate number: " + result); // Expected output: 8
    }
}
