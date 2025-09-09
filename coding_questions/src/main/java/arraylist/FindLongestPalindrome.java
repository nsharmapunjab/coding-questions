package arraylist;

public class FindLongestPalindrome {

	public static void main(String[] args) {

//		System.out.println(longestPalindromeString("snitina"));
//		System.out.println(longestPalindromeString("31214"));
//		System.out.println(longestPalindromeString("512216"));
		System.out.println("isPlaindome : " + isPlaindrome("snitina"));
	}

	public static String longestPalindromeString(String s) {

		if (s == null)
			return null;
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length() - 1; i++) {
			// odd cases like 121
			String palindrome = intermediatePalindrome(s, i, i);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
			// even cases like 1221
			palindrome = intermediatePalindrome(s, i, i + 1);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
		}
		return longest;
	}

	static public boolean isPlaindrome(String s) {

		System.out.println(s);
		s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");
		int left=0;
		int right=s.length()-1;

		while(left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		System.out.println(s);


		return true;
	}

	static public String intermediatePalindrome(String s, int left, int right) {

		if (left > right)
			return null;
		while (left >= 0 && right < s.length()
				&& s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}

}
