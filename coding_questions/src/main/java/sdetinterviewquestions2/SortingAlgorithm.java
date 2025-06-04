package sdetinterviewquestions2;

public class SortingAlgorithm {

	// Sorting algorithm from two loops to one loop
	public static void main(String[] args) {

		int[] arr = new int[] { 8, 9, 6, 7, 4, 5, 2, 3, 1 };
		int i = 0;
		boolean swapped = true;
		while (swapped) {
			if (i < arr[i + 1]) {
				int temp = arr[i + 1];
				arr[i + 1] = arr[i];
				arr[i] = temp;
				swapped = true;
				i = 0;
			} else {
				i++;
				swapped = false;
			}
		}
		for (int j = 0; j < arr.length; j++) {
			System.out.println(arr[j]);
		}
	}

}
