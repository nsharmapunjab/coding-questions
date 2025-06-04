package sortingandsearching;

public class FindElemInSortedMatrix {

	public static void main(String[] args) {

		int[][] matrix = new int[4][3];
		int k = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = k;
				k++;
			}
		}

		System.out.println("Find elem in matrix : "
				+ findElem(matrix, 11, 4, 3));
	}

	public static boolean findElem(int[][] matrix, int elem, int m, int n) {

		int row = 0;
		int column = n - 1;

		while (row < m && column >= 0) {
			if (matrix[row][column] == elem) {
				return true;
			} else if (matrix[row][column] > elem) {
				column--;
			} else {
				row++;
			}
		}

		return false;
	}

}
