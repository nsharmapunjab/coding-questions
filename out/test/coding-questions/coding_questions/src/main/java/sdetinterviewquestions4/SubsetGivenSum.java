package sdetinterviewquestions4;

public class SubsetGivenSum {
    
    /**
     * Checks if there's a subset of the given array with the specified sum
     * @param arr The input array of integers
     * @param sum The target sum to find
     * @return true if a subset with the given sum exists, false otherwise
     */
    public static boolean hasSubsetWithSum(int[] arr, int sum) {
        int n = arr.length;
        // dp[i][j] will be true if there is a subset of elements from arr[0..i-1] with sum equal to j
        boolean[][] dp = new boolean[n + 1][sum + 1];
        
        // If sum is 0, then answer is true (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        
        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // If current element is greater than sum, we can't include it
                // Example: arr[i-1] = 10, j = 5, then we can't include 10 in the subset
                if (arr[i-1] > j) {
                    // Just copy the result from previous row
                    dp[i][j] = dp[i-1][j];
                } else {
                    // Check if sum can be obtained by either including or excluding the current element
                    // Example: arr[i-1] = 3, j = 9, then we can either include 3 or exclude it
                    // If we include 3, then we need to find a subset of arr[0..i-2] with sum 9-3 = 6
                    // If we exclude 3, then we need to find a subset of arr[0..i-2] with sum 9
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - arr[i-1]];
                }
            }
        }
        
        
        return dp[n][sum];
    }
    
    public static void main(String[] args) {
        // Test case 1: Subset with sum exists
        int[] arr1 = {3, 34, 4, 12, 5, 2};
        int sum1 = 9;
        System.out.println("Array: " + java.util.Arrays.toString(arr1));
        System.out.println("Sum: " + sum1);
        System.out.println("Subset with sum exists: " + hasSubsetWithSum(arr1, sum1));
        
        // Test case 2: No subset with sum
        int[] arr2 = {3, 34, 4, 12, 5, 2};
        int sum2 = 30;
        System.out.println("\nArray: " + java.util.Arrays.toString(arr2));
        System.out.println("Sum: " + sum2);
        System.out.println("Subset with sum exists: " + hasSubsetWithSum(arr2, sum2));
        
        // Test case 3: Empty array
        int[] arr3 = {};
        int sum3 = 0;
        System.out.println("\nArray: " + java.util.Arrays.toString(arr3));
        System.out.println("Sum: " + sum3);
        System.out.println("Subset with sum exists: " + hasSubsetWithSum(arr3, sum3));
        
        // Test case 4: Single element array
        int[] arr4 = {5};
        int sum4 = 5;
        System.out.println("\nArray: " + java.util.Arrays.toString(arr4));
        System.out.println("Sum: " + sum4);
        System.out.println("Subset with sum exists: " + hasSubsetWithSum(arr4, sum4));
    }
}
