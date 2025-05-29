package sortingandsearching;

import java.util.Arrays;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {

		int[] a = new int[10];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		a[4] = 5;
		a[5] = 7;
		System.out.println("Array a : " + Arrays.toString(a));
		int[] b = { 9, 10, 12, 13 };
		System.out.println("Array b : " + Arrays.toString(b));
		System.out.println("Merged Array : "
				+ Arrays.toString(mergeTwoArrays(a, b, 6, b.length)));

	}

	public static int[] mergeTwoArrays(int[] a, int[] b, int m, int n) {

		int k = m + n - 1;
		int i = m - 1;
		int j = n - 1;

		while (i >= 0 && j >= 0) {

			if (a[i] > b[j]) {
				a[k--] = a[i--];
			} else {
				a[k--] = b[j--];
			}
		}

		while (j >= 0) {

			a[k--] = b[j--];
		}

		return a;
	}

}
