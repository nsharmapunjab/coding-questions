package recursion;

public class FibonacciSeries {

	public static void main(String[] args) {

		System.out.println("Fibonacci Series Recursive : " + fiboRecursive(4));
		System.out.println("Fibonacci Series Iterative : " + fiboIterative(4));
	}

	// Recursive Solution
	public static int fiboRecursive(int n) {

		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (n > 1) {
			return fiboRecursive(n - 1) + fiboRecursive(n - 2);
		} else {
			return -1;
		}
	}

	// Iterative Solution
	public static int fiboIterative(int n) {

		if (n < 0) {
			return -1;
		}
		if (n == 0) {
			return 0;
		}
		int a = 1, b = 1;
		for (int i = 3; i <= n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}

		return b;
	}

}
