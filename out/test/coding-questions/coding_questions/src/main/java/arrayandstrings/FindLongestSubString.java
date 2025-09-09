package arrayandstrings;

import java.util.HashSet;
import java.util.Set;

public class FindLongestSubString {

	public static void main(String[] args) {

		String str1 = "abcdefacbccbagfacbacer";
		String str2 = "abc";

		System.out.println("STR1 : " + str1);
		System.out.println("STR2 : " + str2);

		System.out.println("Longest subString : "
				+ findLongestSubString(str1, str2));
	}

	public static String findLongestSubString(String str1, String str2) {

		Set<Character> set = new HashSet<>();
		for (int i = 0; i < str2.length(); i++) {
			set.add(str2.charAt(i));
		}

		int longest = 0;
		int current = 0;
		int longestEnd = -1;
		for (int i = 0; i < str1.length(); i++) {
			if (set.contains(str1.charAt(i))) {
				current++;
				if (current > longest) {
					longest = current;
					longestEnd = i + 1;
				}
			} else {
				current = 0;
			}
		}

		String result = "";
		if (longest > 0) {
			System.out.println("Longest : " + longest);
			System.out.println("LongestEnd : " + longestEnd);
			result = str1.substring(longestEnd - longest, longestEnd);
		}

		return result;
	}
}
