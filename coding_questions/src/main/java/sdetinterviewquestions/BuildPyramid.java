package sdetinterviewquestions;

public class BuildPyramid {

	public static void main(String[] args) {

		int n = 5;
		// simplePyramid(n);
		// DegreeRotation(n);
		printTriagle(n);
		// printNums(n);
		// printNumsWdoutReassigning(n);
	}

	public static void simplePyramid(int n) {
		int i, j;

		// outer loop to handle number of rows
		// n in this case
		for (i = 0; i < n; i++) {

			// inner loop to handle number of columns
			// values changing acc. to outer loop
			for (j = 0; j <= i; j++) {
				// printing stars
				System.out.print("* ");
			}

			// ending line after each row
			System.out.println("");
		}
	}

	public static void DegreeRotation(int n) {
		// number of spaces
		int i, j;
		// int k = 2 * n - 2;
		int k = n - 1;

		// outer loop to handle number of rows
		// n in this case
		for (i = 0; i < n; i++) {

			// inner loop to handle number spaces
			// values changing acc. to requirement
			for (j = 0; j < k; j++) {
				// printing spaces
				System.out.print(" ");
			}

			// decrementing k after each loop
			k = k - 1;

			// inner loop to handle number of columns
			// values changing acc. to outer loop
			for (j = 0; j <= i; j++) {
				// printing stars
				System.out.print("*");
			}

			// ending line after each row
			System.out.println();
		}
	}

	public static void printTriagle(int n) {
		// number of spaces
		// int k = 2 * n - 2;
		int k = n - 1;

		// outer loop to handle number of rows
		// n in this case
		for (int i = 0; i < n; i++) {

			// inner loop to handle number spaces
			// values changing acc. to requirement
			for (int j = 0; j < k; j++) {
				// printing spaces
				System.out.print(" ");
			}

			// decrementing k after each loop
			k = k - 1;

			// inner loop to handle number of columns
			// values changing acc. to outer loop
			for (int j = 0; j <= i; j++) {
				// printing stars
				System.out.print("* ");
			}

			// ending line after each row
			System.out.println();
		}
	}

	public static void printNums(int n) {
		int i, j, num;

		// outer loop to handle number of rows
		// n in this case
		for (i = 0; i < n; i++) {
			// initialising starting number
			num = 1;

			// inner loop to handle number of columns
			// values changing acc. to outer loop
			for (j = 0; j <= i; j++) {
				// printing num with a space
				System.out.print(num + " ");

				// incrementing value of num
				num++;
			}

			// ending line after each row
			System.out.println();
		}
	}

	public static void printNumsWdoutReassigning(int n) {
		// initialising starting number
		int i, j, num = 1;

		// outer loop to handle number of rows
		// n in this case
		for (i = 0; i < n; i++) {

			// without re assigning num
			// num = 1;
			for (j = 0; j <= i; j++) {
				// printing num with a space
				System.out.print(num + " ");

				// incrementing num at each column
				num = num + 1;
			}

			// ending line after each row
			System.out.println();
		}
	}

}
