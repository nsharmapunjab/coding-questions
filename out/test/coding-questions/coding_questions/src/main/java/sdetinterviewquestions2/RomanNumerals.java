package sdetinterviewquestions2;

public class RomanNumerals {

	public static void main(String[] args) {

		int dec = 39;
		String[] ten = new String[] { "x", "xx", "xxx" };
		String[] unit = new String[] { "i", "ii", "iii", "iv", "v", "vi",
				"vii", "viii", "ix", "x" };
		int tens = dec / 10;
		int units = dec % 10;
		System.out.println(ten[tens - 1] + unit[units - 1]);
	}

}
