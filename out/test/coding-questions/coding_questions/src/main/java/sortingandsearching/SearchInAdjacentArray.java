package sortingandsearching;

import java.util.Arrays;

public class SearchInAdjacentArray {

	// x is the elmenet to be searched
	// in arr[0..n-1]
	static int search(int arr[], int n, int x) {

		// Travers the given array starting
		// from leftmost element
		int i = 0;
		while (i < n) {

			// If x is found at index i
			if (arr[i] == x)
				return i;

			// Jump the difference between current
			// array element and x
			i = i + Math.abs(arr[i] - x);
		}

		System.out.println("number is not" + " present!");

		return -1;
	}

	// Driver program to test above function
	public static void main(String[] args) {

		int arr[] = { 8, 7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3 };
		int n = arr.length;
		int x = 3;
		System.out.println("Input Array : " + Arrays.toString(arr));
		System.out.println("Element to find : " + x);
		System.out.println("Element " + x + " is present at index "
				+ search(arr, n, 3));
	}

}
