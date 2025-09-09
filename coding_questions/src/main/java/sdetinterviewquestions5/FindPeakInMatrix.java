package src.main.java.sdetinterviewquestions5;

public class FindPeakInMatrix {

    public static int[] findPeak(int[][] matrix) {
        return findPeakRec(matrix, 0, matrix[0].length - 1);
    }

    private static int[] findPeakRec(int[][] matrix, int startCol, int endCol) {
        int numRows = matrix.length;

        int midCol = startCol + (endCol - startCol) / 2;

        // Find index of max element in midCol
        int maxRow = 0;
        for (int i = 0; i < numRows; i++) {
            if (matrix[i][midCol] > matrix[maxRow][midCol]) {
                maxRow = i;
            }
        }

        int midValue = matrix[maxRow][midCol];

        // Check left and right neighbors
        int left = (midCol - 1 >= 0) ? matrix[maxRow][midCol - 1] : Integer.MIN_VALUE;
        int right = (midCol + 1 < matrix[0].length) ? matrix[maxRow][midCol + 1] : Integer.MIN_VALUE;

        // Peak condition
        if (midValue >= left && midValue >= right) {
            return new int[]{maxRow, midCol};
        }

        // If left neighbor is greater, search left half
        if (left > midValue) {
            return findPeakRec(matrix, startCol, midCol - 1);
        }

        // Else search right half
        return findPeakRec(matrix, midCol + 1, endCol);
    }

    public static void main(String[] args) {

//        int[][] matrix = new int[3][3];
//        int k = 1;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                matrix[i][j] = k;
//                k++;
//            }
//        }

        int[][] matrix = {
                {1, 2, 3},
                {4, 8, 6},
                {7, 5, 9}
        };

//        int[][] matrix = {
//                {10, 8, 10, 10},
//                {14, 13, 12, 11},
//                {15, 9, 11, 21},
//                {16, 17, 19, 20}
//        };

        int[] peak = findPeak(matrix);
        System.out.println("Peak found at: (" + peak[0] + ", " + peak[1] + ") = " + matrix[peak[0]][peak[1]]);
    }
}
