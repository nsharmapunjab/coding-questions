package arraylist;

import java.util.Arrays;

public class SetZeroMatrix {

	public static void main(String[] args) {

		int[][] matrix = new int[3][3];

		int k = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = k;
				k++;
			}
		}
		matrix[1][2]=0;
		System.out.println("Given Matrix : " + Arrays.deepToString(matrix));

		System.out.println("Final Matrix : "
				+ Arrays.deepToString(setZeros(matrix)));
	}

	public static int[][] setZeros(int[][] matrix) {

		int[] row = new int[matrix.length];
		int[] column = new int[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = 1;
					column[j] = 1;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] == 1 || column[j] == 1) {
					matrix[i][j] = 0;
				}
			}
		}

		return matrix;
	}

}
