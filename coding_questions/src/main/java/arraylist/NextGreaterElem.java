package arraylist;

public class NextGreaterElem {

	public static void main(String[] args) {

		int arr[] = { 11, 5, 21, 51, 41, 3, 13 };
		int n = arr.length;
		nextGreaterElem(arr, n);
	}

	public static void nextGreaterElem(int[] arr, int n) {

		int next, i, j;
		for (i = 0; i < n; i++) {
			next = -1;
			for (j = i + 1; j < n; j++) {
				if (arr[i] < arr[j]) {
					next = arr[j];
					break;
				}
			}
			System.out.println(arr[i] + " -- " + next);
		}
	}

}
