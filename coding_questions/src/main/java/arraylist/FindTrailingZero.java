package arraylist;

public class FindTrailingZero {

	public static void main(String[] args) {

		int num = 100;
		if (num < 0) {
			System.out.println("Factorial is not defined for <0");
		}
		int count = 0;
		for (int i = 5; num / i > 0; i *= 5) {
			count += num / i;
		}

		System.out.println("Trailing zero count : " + count);
	}

}
