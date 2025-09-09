package recursion;

import java.util.Arrays;

public class PrintParenthesis {

	public static void main(String[] args) {

		printParenthesis(3);
	}

	public static void printParenthesis(int count) {

		char[] str = new char[count * 2];
		printParenthesis(count, count, str, 0);
	}

	public static void printParenthesis(int l, int r, char[] str, int count) {

		//System.out.println("Iteration : l=" + l + ", r=" + r + ", count=" + count + ", str=" + Arrays.toString(str));
		if (l < 0 || r < l) {
			return; // invalid state
		}
		if (l == 0 && r == 0) {
			System.out.println(str); // found one, so print it
		} else {
			if (l > 0) { // try a left parenthesis, if there are some available
				str[count] = '(';
				printParenthesis(l - 1, r, str, count + 1);
			}
			if (r > l) { // try a right parenthesis, if there’s a matching left
				str[count] = ')';
				printParenthesis(l, r - 1, str, count + 1);
			}
		}
	}

}
