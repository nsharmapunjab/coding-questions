package arraylist;

public class SwapNumbers {

	public static void main(String[] args) {

		int a = 3;
		int b = 5;

		System.out.println("Given a : " + a);
		System.out.println("Given b : " + b);

		swapNumbersWithoutTempVar(a, b);
	}

	public static void swapNumbersWithoutTempVar(int a, int b) {

		b = a + b;
		a = b - a;
		b = b - a;

		System.out.println("Output a : " + a);
		System.out.println("Output b : " + b);
	}

}
