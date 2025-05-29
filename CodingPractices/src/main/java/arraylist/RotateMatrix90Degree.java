package arraylist;

import java.util.Arrays;

public class RotateMatrix90Degree {

	public static void main(String[] args) {
		
		int[][] matrix = new int[3][3];

		int k = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = k;
				k++;
			}
		}
		System.out.println("Given Matrix : " + Arrays.deepToString(matrix));

		System.out.println("Final Matrix : "
				+ Arrays.deepToString(rotateMatrix(matrix, 3)));
	}

	public static int[][] rotateMatrix(int[][] matrix, int n) {

		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last - offset][first];
				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];
				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				// top -> right
				matrix[i][last] = top;
			}
		}

		return matrix;
	}
	
	public static int[][] rotateMatrix1(int[][] matrix, int n) {

		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last - offset][first];
				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];
				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				// top -> right
				matrix[i][last] = top;
			}
		}

		return matrix;
	}
}
