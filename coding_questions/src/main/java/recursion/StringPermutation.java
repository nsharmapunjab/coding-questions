package recursion;

import java.util.ArrayList;

public class StringPermutation {

	public static void main(String[] args) {

		String str = "abc";
		ArrayList<String> permutations = getPerms(str);
		System.out.println("Permutations of given string : " + permutations);
	}

	public static ArrayList<String> getPerms(String str) {

		ArrayList<String> permutations = new ArrayList<String>();
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			permutations.add("");
			return permutations;
		}

		char first = str.charAt(0);
		String remainder = str.substring(1);
		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {
			for (int i = 0; i <= word.length(); i++) {
				permutations.add(insertCharAt(word, first, i));
			}
		}
		return permutations;
	}

	public static String insertCharAt(String word, char c, int i) {

		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}

}
