package arraylist;

public class EvaluateArrayExpression {

	// Function to find the sum of given array
	public static int calculateSum(String arr[], int n) {

		// if string is empty
		if (n == 0)
			return 0;
		String s = arr[0];

		// parseInt function to convert
		// string into integer
		int value = Integer.parseInt(s);
		int sum = value;

		for (int i = 2; i < n; i = i + 2) {
			s = arr[i];

			// parseInt function to convert
			// string into integer
			value = Integer.parseInt(s);

			// Find operator
			char operation = arr[i - 1].charAt(0);

			// If operator is equal to '+',
			// add value in sum variable
			// else subtract
			if (operation == '+')
				sum += value;
			else
				sum -= value;
		}
		return sum;
	}

	// Driver code
	public static void main(String[] args) {
		String arr[] = { "3", "+", "4", "-", "7", "+", "13" };
		int n = arr.length;
		System.out.println(calculateSum(arr, n));
	}

}
