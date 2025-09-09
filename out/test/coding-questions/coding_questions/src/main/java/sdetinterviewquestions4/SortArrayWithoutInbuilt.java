package sdetinterviewquestions4;

import java.util.Arrays;

public class SortArrayWithoutInbuilt {
    
    /**
     * Sorts an array of 0s, 1s, and 2s in ascending order using the Dutch National Flag algorithm.
     * @param nums The input array to be sorted (will be modified in-place)
     */
    public static void sort012(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return; // No sorting needed for empty or single-element array
        }
        
        int low = 0;              // Points to the end of 0s section
        int mid = 0;               // Current element being processed
        int high = nums.length - 1; // Points to the start of 2s section
        
        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    // Move 0 to the low section
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    // 1 is in the correct section, just move mid pointer
                    mid++;
                    break;
                case 2:
                    // Move 2 to the high section
                    swap(nums, mid, high);
                    high--;
                    break;
            }
        }
    }
    
    /**
     * Helper method to swap two elements in an array
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        // Test case 1: Normal case
        int[] arr1 = {2, 0, 2, 1, 1, 0};
        System.out.println("Original array 1: " + Arrays.toString(arr1));
        sort012(arr1);
        System.out.println("Sorted array 1:   " + Arrays.toString(arr1));
        
        // Test case 2: Already sorted
        int[] arr2 = {0, 0, 1, 1, 2, 2};
        System.out.println("\nOriginal array 2: " + Arrays.toString(arr2));
        sort012(arr2);
        System.out.println("Sorted array 2:   " + Arrays.toString(arr2));
        
        // Test case 3: All elements are the same
        int[] arr3 = {1, 1, 1, 1};
        System.out.println("\nOriginal array 3: " + Arrays.toString(arr3));
        sort012(arr3);
        System.out.println("Sorted array 3:   " + Arrays.toString(arr3));
        
        // Test case 4: Single element
        int[] arr4 = {2};
        System.out.println("\nOriginal array 4: " + Arrays.toString(arr4));
        sort012(arr4);
        System.out.println("Sorted array 4:   " + Arrays.toString(arr4));
        
        // Test case 5: Empty array
        int[] arr5 = {};
        System.out.println("\nOriginal array 5: " + Arrays.toString(arr5));
        sort012(arr5);
        System.out.println("Sorted array 5:   " + Arrays.toString(arr5));
    }
}
