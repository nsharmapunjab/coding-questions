package sdetinterviewquestions2;

import java.util.HashMap;

public class FindMaxWdotAdjacent {

	/*
	 * Function to return max sum such that no two elements are adjacent
	 */
	int FindMaxSum(int arr[], int n) {
		int incl = arr[0];
		int excl = 0;
		int excl_new;
		int i;

		for (i = 1; i < n; i++) {
			/* current max excluding i */
			excl_new = (incl > excl) ? incl : excl;

			/* current max including i */
			incl = excl + arr[i];
			excl = excl_new;
		}

		/* return max of incl and excl */
		return ((incl > excl) ? incl : excl);
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		FindMaxWdotAdjacent sum = new FindMaxWdotAdjacent();
		// int arr[] = new int[] { 5, 5, 10, 100, 10, 5 };
		int arr[] = { 10000, 10, 1, 2 };
		// int arr[] = {23, 1000, 9, 1, 10, 234565495839, 7889999999}
		System.out.println(sum.FindMaxSum(arr, arr.length));
		
		// HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// map.put(null, 1);
		// System.out.println(map);
		// System.out.println(map.get(null));
	}

}
