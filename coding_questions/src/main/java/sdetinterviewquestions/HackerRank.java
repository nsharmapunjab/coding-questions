package sdetinterviewquestions;


public class HackerRank {

	// TODO :- pending to complete code
	// Sample Input
	//
	// 2
	// 5 42
	// 3 25
	// Sample Output
	//
	// aaamz
	// aaw
	//
	// Explanation
	// string value of aaamz is 42 also, it is smallest lexicographical string
	// such that it contains 5 characters and has string value 42.
	//
	// Note: Your code should be able to convert the sample input into the
	// sample output. However, this is not enough to pass the challenge, because
	// the code will be run on multiple test cases. Therefore, your code must
	// solve this problem statement.

	public static void main(String[] args) {

		generateLexicoString(1, 26);
	}

	static void generateLexicoString(int n, int k) {

		char[] a = new char[n];
		// Initially fill the array with character 'a'
		for (int i = 0; i < n; i++) {
			a[i] = 'a';
		}
		int a_count = n;
		int tot_count = k;
		int x = tot_count - a_count;
		for (int i = n - 1; i >= 0; i--) {
			if (x > 26) {
				a[i] = 'z';
				x = (x - 26) + 1;
			} else if (x > 0) {
				a[i] = (char) (a[i] + x);
				x = 0;
			}
			if (x == 0)
				break;
		}
		String op = "";
		for (int i = 0; i < n; i++) {
			op = op + a[i];
		}
		System.out.println(op);
	}
}
