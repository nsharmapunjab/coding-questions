package arraylist;

import java.util.Arrays;
import java.util.Comparator;

public class FindLongestWord {

	public static void main(String[] args) {

		String[] s = { "test", "tester", "testertest", "testingtester",
				"testing", "testertesttesting",
				"testingtestertestertesttesting" };
		System.out.println("Longest String in Array : " + findLongestWord(s));
	}

	public static String findLongestWord(String[] strArray) {

		// System.out.println("Given String Array : " +
		// Arrays.toString(strArray));
		Arrays.sort(strArray, new StringLengthComparator());
		// System.out
		// .println("Sorted String Array : " + Arrays.toString(strArray));

		String longestString = "";
		boolean lastPartCheck = false;

		for (String str : strArray) {
			longestString = str;
			for (int i = 0; i < str.length(); i++) {
				String firstPart = str.substring(0, i + 1);
				String lastPart = str.substring(i + 1);
				boolean firstPartCheck = searchStringInArray(strArray,
						firstPart);
				if (firstPartCheck) {
					lastPartCheck = searchStringInArray(strArray, lastPart);
				}
				if (lastPartCheck) {
					return longestString;
				}
			}
		}
		return null;
	}

	public static boolean searchStringInArray(String[] arr, String s) {

		for (int i = 0; i < arr.length; i++) {
			if (s.equalsIgnoreCase(arr[i])) {
				return true;
			}
		}

		return false;
	}

	static class StringLengthComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return o2.length() - o1.length();
		}

	}

}
