package sdetinterviewquestions4;

import java.util.HashMap;
import java.util.Map;

public class PairDivisbleByKInArr {

    /**
     * Counts the number of pairs in the array whose sum is divisible by k
     * @param arr Input array of integers
     * @param k The divisor
     * @return Count of pairs whose sum is divisible by k
     */
    /**
     * Time complexity: O(n)
     * Space complexity: O(k)
     * 
     * Counts the number of pairs in the array whose sum is divisible by k
     * @param arr Input array of integers
     * @param k The divisor
     * @return Count of pairs whose sum is divisible by k
     */
    public static int countPairsDivisibleByK(int[] arr, int k) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        
        // Map to store frequency of remainders
        Map<Integer, Integer> remainderFreq = new HashMap<>();
        int count = 0;
        
        for (int num : arr) {
            int remainder = (num % k + k) % k; // Handle negative numbers
            int complement = (k - remainder) % k;
            
            // If complement exists in map, add its frequency to count
            if (remainderFreq.containsKey(complement)) {
                count += remainderFreq.get(complement);
            }
            
            // Update the frequency of current remainder
            remainderFreq.put(remainder, remainderFreq.getOrDefault(remainder, 0) + 1);
        }
        
        return count;
    }

    public static int countKdivPairs(int A[], int n, int K)
    {
        // Create a frequency array to count
        // occurrences of all remainders when
        // divided by K
        int freq[] = new int[K];

        // Count occurrences of all remainders
        for (int i = 0; i < n; i++)
            ++freq[A[i] % K];

        // If both pairs are divisible by 'K'
        int sum = freq[0] * (freq[0] - 1) / 2;

        // count for all i and (k-i)
        // freq pairs
        for (int i = 1; i <= K / 2 && i != (K - i); i++)
            sum += freq[i] * freq[K - i];
        // If K is even
        if (K % 2 == 0)
            sum += (freq[K / 2] * (freq[K / 2] - 1) / 2);
        return sum;
    }
    
    public static void main(String[] args) {
        // Test case 1: From the example
        int[] arr1 = {5, 9, 36, 74, 52, 31, 42};
        int k1 = 3;
        System.out.println("Array: " + java.util.Arrays.toString(arr1));
        System.out.println("k: " + k1);
        // System.out.println("Number of pairs with sum divisible by k: " + 
        //                  countPairsDivisibleByK(arr1, k1));
        System.out.println("Number of pairs with sum divisible by k: " + 
                         countKdivPairs(arr1, arr1.length, k1));
        
        // Test case 2: All elements are divisible by k
        int[] arr2 = {3, 6, 9, 12, 15};
        int k2 = 3;
        System.out.println("\nArray: " + java.util.Arrays.toString(arr2));
        System.out.println("k: " + k2);
        System.out.println("Number of pairs with sum divisible by k: " + 
                         countPairsDivisibleByK(arr2, k2));
        
        // Test case 3: No pairs
        int[] arr3 = {1, 2, 3, 4, 5};
        int k3 = 10;
        System.out.println("\nArray: " + java.util.Arrays.toString(arr3));
        System.out.println("k: " + k3);
        System.out.println("Number of pairs with sum divisible by k: " + 
                         countPairsDivisibleByK(arr3, k3));
        
        // Test case 4: With negative numbers
        int[] arr4 = {-1, 2, 4, -3, 5, 7};
        int k4 = 3;
        System.out.println("\nArray: " + java.util.Arrays.toString(arr4));
        System.out.println("k: " + k4);
        System.out.println("Number of pairs with sum divisible by k: " + 
                         countPairsDivisibleByK(arr4, k4));
    }
}
