package sdetinterviewquestions;

public class FindCommonPrefix {

	public static void main(String[] args) {

		String[] str = { "geeksforgeeks", "geeks", "geek", "geezer" };
//		String[] str = {"apple", "ape", "april"};

		System.out.println("Longest prefix : " + longestCommonPrefix(str));
	}

	public static String longestCommonPrefix(String[] strings) {
		
		if (strings.length == 0) {
			return ""; // Or maybe return null?
		}

		for (int prefixLen = 0; prefixLen < strings[0].length(); prefixLen++) {
			char c = strings[0].charAt(prefixLen);
			for (int i = 1; i < strings.length; i++) {
				if (prefixLen >= strings[i].length()
						|| strings[i].charAt(prefixLen) != c) {
					// Mismatch found
					return strings[i].substring(0, prefixLen);
				}
			}
		}
		return strings[0];
	}

}
