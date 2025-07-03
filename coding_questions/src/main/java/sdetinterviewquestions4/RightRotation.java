package sdetinterviewquestions4;

import java.util.Arrays;

public class RightRotation {

    /**
     * Performs a right rotation by one position on the given array
     * @param arr The input array to be rotated
     * @return A new array that is the result of the right rotation
     * @throws IllegalArgumentException if the input array is null
     */
    public static int[] rotateRightByOne(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        
        // If array is empty or has only one element, return as is
        if (arr.length <= 1) {
            return null;
        }
        
        // Store the last element
        int last = arr[arr.length - 1];
        
        // Shift all other elements one position to the right
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        
        // Place the last element at the first position
        arr[0] = last;
        return arr;
    }
    
    public static void main(String[] args) {
        // Test case 1: Normal case
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("Original array 1: " + Arrays.toString(arr1));
        int[] rotated1 = rotateRightByOne(arr1);
        System.out.println("After right rotation: " + Arrays.toString(rotated1));
        
        // Test case 2: Single element array
        int[] arr2 = {42};
        System.out.println("\nOriginal array 2: " + Arrays.toString(arr2));
        int[] rotated2 = rotateRightByOne(arr2);
        System.out.println("After right rotation: " + Arrays.toString(rotated2));
        
        // Test case 3: Empty array
        int[] arr3 = {};
        System.out.println("\nOriginal array 3: " + Arrays.toString(arr3));
        int[] rotated3 = rotateRightByOne(arr3);
        System.out.println("After right rotation: " + Arrays.toString(rotated3));
        
        // Test case 4: Two elements
        int[] arr4 = {10, 20};
        System.out.println("\nOriginal array 4: " + Arrays.toString(arr4));
        int[] rotated4 = rotateRightByOne(arr4);
        System.out.println("After right rotation: " + Arrays.toString(rotated4));
        
        // Test case 5: With negative numbers
        int[] arr5 = {-1, -2, -3, 0, 1, 2};
        System.out.println("\nOriginal array 5: " + Arrays.toString(arr5));
        int[] rotated5 = rotateRightByOne(arr5);
        System.out.println("After right rotation: " + Arrays.toString(rotated5));
    }
}
