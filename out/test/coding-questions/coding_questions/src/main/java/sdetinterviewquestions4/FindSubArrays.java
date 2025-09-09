package sdetinterviewquestions4;

import java.util.*;

public class FindSubArrays {
    
    public static List<List<Integer>> findSubArraysWithZeroSum(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        
        // Map to store the sum and the list of indices where this sum occurs
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        
        // Initialize with sum 0 at index -1 to handle subarrays starting from index 0
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));
        
        int currentSum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            
            // If the current sum has been seen before, there are subarrays with zero sum
            if (sumMap.containsKey(currentSum)) {
                // Get all previous indices where this sum occurred
                for (int start : sumMap.get(currentSum)) {
                    // The subarray from (start + 1) to i has sum 0
                    List<Integer> subarray = new ArrayList<>();
                    for (int j = start + 1; j <= i; j++) {
                        subarray.add(arr[j]);
                    }
                    result.add(subarray);
                }
                // Add current index to the list of indices for this sum
                sumMap.get(currentSum).add(i);
            } else {
                // If this sum is seen for the first time, create a new entry
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                sumMap.put(currentSum, indices);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test case
        // int[] arr = {4, -3, 2, 1, 6, -4, -2, 3, 5};
        // List<List<Integer>> result = findSubArraysWithZeroSum(arr);
        
        // System.out.println("Input array: [4, -3, 2, 1, 6, -4, -2, 3, 5]");
        // System.out.println("Subarrays with sum zero:");
        // for (List<Integer> subarray : result) {
        //     System.out.println(subarray);
        // }

        int[] arr
            = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
            System.out.println(Arrays.toString(arr));
        int n = arr.length;

        ArrayList<Pair> out = findSubArrays(arr, n);

        // if we did not find any subarray with 0 sum,
        // then subarray does not exists
        if (out.size() == 0)
            System.out.println("No subarray exists");
        else
            print(out);
    }

    // Function to print all subarrays in the array which
    // has sum 0
    static ArrayList<Pair> findSubArrays(int[] arr, int n)
    {
        // create an empty map
        HashMap<Integer, ArrayList<Integer> > map
            = new HashMap<>();

        // create an empty vector of pairs to store
        // subarray starting and ending index
        ArrayList<Pair> out = new ArrayList<>();

        // Maintains sum of elements so far
        int sum = 0;

        for (int i = 0; i < n; i++) {
            // add current element to sum
            sum += arr[i];
            // if sum is 0, we found a subarray starting
            // from index 0 and ending at index i
            if (sum == 0) {
                out.add(new Pair(0, i));
            }
            ArrayList<Integer> al = new ArrayList<>();
            System.out.println("sum : " + sum);

            // If sum already exists in the map there exists
            // at-least one subarray ending at index i with
            // 0 sum
            if (map.containsKey(sum)) {
                // map[sum] stores starting index of all
                // subarrays
                al = map.get(sum);
                for (int it = 0; it < al.size(); it++) {
                    System.out.println("al.get(it) : " + al.get(it));
                    out.add(new Pair(al.get(it) + 1, i));
                }
            }
            al.add(i);
            map.put(sum, al);
        }
        return out;
    }

    // Utility function to print all subarrays with sum 0
    static void print(ArrayList<Pair> out)
    {
        for (int i = 0; i < out.size(); i++) {
            Pair p = out.get(i);
            System.out.println("Subarray found from Index "
                               + p.first + " to "
                               + p.second);
        }
    }

    // User defined pair class
static class Pair {
    int first, second;
    Pair(int a, int b)
    {
        first = a;
        second = b;
    }
}
}
