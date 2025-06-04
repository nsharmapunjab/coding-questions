package arraylist;

public class GetMaximumSum {

	public static void main(String[] args) {

		int[] a = { 2, -8, 3, -2, 4, -10 };
		System.out.println("Maximum sum of array : " + getMaxSum(a));
	}

	public static int getMaxSum(int[] a) {

		int maxSum = 0;
		int sum = 0;

		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (maxSum < sum) {
				maxSum = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}

		return maxSum;
	}

}
