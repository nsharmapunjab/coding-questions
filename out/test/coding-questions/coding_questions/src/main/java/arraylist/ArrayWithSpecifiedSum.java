package arraylist;

import java.util.Arrays;

public class ArrayWithSpecifiedSum {

	public static void main(String[] args) {

		int[] a = { -2, -1, 0, 3, 5, 6, 13, 14, 7, 9 };
		findSumOfElem(a, 6);
	}

	public static void findSumOfElem(int[] a, int sum) {

		System.out.println("Given Array : " + Arrays.toString(a));
		Arrays.sort(a);
		System.out.println("Sorted Array : " + Arrays.toString(a));
		int first = 0;
		int last = a.length - 1;
		while (first < last) {
			int s = a[first] + a[last];
			if (s == sum) {
				System.out.println(a[first] + " " + a[last]);
				first++;
				last--;
			}
			if (s < sum) {
				first++;
			} else if (s > sum) {
				last--;
			}
		}
	}

}
