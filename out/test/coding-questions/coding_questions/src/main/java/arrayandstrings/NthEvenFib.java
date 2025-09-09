package arrayandstrings;

public class NthEvenFib {

	static long evenFib(int n) {
		if (n < 1)
			return n;

		if (n == 1)
			return 2;

		// calculation of Fn = 4*(Fn-1) + Fn-2
		return ((4 * evenFib(n - 1)) + evenFib(n - 2));
	}

	/* Driver program */
	public static void main(String[] args) {
		int n = 3;
		System.out.println(evenFib(n));
	}
}
