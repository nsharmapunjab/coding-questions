/**
 * 
 */
package sdet2019questions;

import java.util.HashMap;

/**
 * @author Nitin Sharma
 *
 */
public class MakePermutation {

	/**
	 * 
	 * Given an array A of n elements. We need to change the array into a
	 * permutation of numbers from 1 to n using minimum replacements in the array.
	 * 
	 * Examples:
	 * 
	 * Input : A[] = {2, 2, 3, 3} Output : 2 1 3 4 Explanation: To make it a
	 * permutation of 1 to 4, 1 and 4 are missing from the array. So replace 2, 3
	 * with 1 and 4.
	 * 
	 * Input : A[] = {1, 3, 2} Output : 1 3 2
	 * 
	 * Input : A[] = {10, 1, 2} Output : 3 1 2
	 */

	static void makePermutation(int[] a, int n) {
		// Store counts of all elements.
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			if (count.containsKey(a[i])) {
				count.put(a[i], count.get(a[i]) + 1);
			} else {
				count.put(a[i], 1);
			}
		}

		int next_missing = 1;
		for (int i = 0; i < n; i++) {
			if (count.containsKey(a[i]) && count.get(a[i]) != 1 || a[i] > n || a[i] < 1) {
				count.put(a[i], count.get(a[i]) - 1);

				// Find next missing element to put
				// in place of current element.
				while (count.containsKey(next_missing))
					next_missing++;

				// Replace with next missing and insert
				// the missing element in hash.
				a[i] = next_missing;
				count.put(next_missing, 1);
			}
		}
	}

	// Driver Code
	public static void main(String[] args) {
		int A[] = { 2, 2, 3, 3 };
		int n = A.length;
		makePermutation(A, n);
		for (int i = 0; i < n; i++)
			System.out.print(A[i] + " ");
	}
}
