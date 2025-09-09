package recursion;

public class MakeChange {

	public static void main(String[] args) {

		System.out.println("No. of ways to make change : "
				+ makeChange(10, 25));
	}

	public static int makeChange(int n, int denom) {
		/**
		 * This function calculates the number of ways to make change for n cents
		 * using the denominations given by the parameters. 
		 * 
		 * The denominations are given by the following rules:
		 * 1. If denom is 25, the next denomination is 10.
		 * 2. If denom is 10, the next denomination is 5.
		 * 3. If denom is 5, the next denomination is 1.
		 * 4. If denom is 1, there are no more denominations, so return 1.
		 * 
		 * The function works by trying all possible combinations of coins.
		 * For each combination, it calculates the number of ways to make change
		 * using the remaining amount of money and the next denomination.
		 * 
		 * It then adds up all the results to get the total number of ways.
		 */
		int next_denom = 0;
		switch (denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}
		int ways = 0;
		/**
		 * Try all possible combinations of coins.
		 * For each combination, calculate the number of ways to make change
		 * using the remaining amount of money and the next denomination.
		 */
		for (int i = 0; i * denom <= n; i++) {
			ways += makeChange(n - i * denom, next_denom);
		}

		return ways;
	}

}
