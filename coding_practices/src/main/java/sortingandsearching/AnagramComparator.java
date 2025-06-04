package sortingandsearching;

import java.util.Arrays;
import java.util.Comparator;

public class AnagramComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {

		return sortChars(s1).compareTo(sortChars(s2));
	}

	public String sortChars(String s) {

		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

	public static void main(String[] args) {

		String[] strArray = { "watermelon", "nitin", "melonwater", "nniit" };
		System.out.println("Given String Array : " + Arrays.toString(strArray));
		Arrays.sort(strArray, new AnagramComparator());
		System.out
				.println("Output String Array : " + Arrays.toString(strArray));
	}

}
