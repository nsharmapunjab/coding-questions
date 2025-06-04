package arrayandstrings;

import java.util.ArrayList;

public class TestClass {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ArrayList<Integer> outputArr = new ArrayList<Integer>();
		ArrayList<Integer> finalArray = new ArrayList<Integer>();
		int windowSize = 3;
		int sum = 0;

		// 1st implementation
//		if (windowSize > 1) {
//			for (int i = arr.length - 1; i >= windowSize - 1; i--) {
//				for (int j = 0; j < windowSize; j++) {
//					sum = sum + arr[i - j];
//				}
//				outputArr.add(sum);
//				sum = 0;
//			}
//		}

		// 2nd implementation
		if (windowSize > 1) {
			for (int i = 0; i <= arr.length - windowSize; i++) {
				for (int j = 0; j < windowSize; j++) {
					sum = sum + arr[i + j];
				}
				outputArr.add(sum);
				sum = 0;
			}
		}

		System.out.println(outputArr);
		for (int i = outputArr.size() - 1; i >= 0; i--) {
			finalArray.add(outputArr.get(i));
		}

		System.out.println(finalArray);
	}

}
