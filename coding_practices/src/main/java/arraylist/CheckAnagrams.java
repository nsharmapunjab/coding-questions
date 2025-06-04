package arraylist;

public class CheckAnagrams {

	public static void main(String[] args) {

		String s1 = "nitin";
		String s2 = "niitn";
		System.out.println("Are Strings anagrams : " + checkAnagrams(s1, s2));
	}

	public static boolean checkAnagrams(String s1, String s2) {

		int[] c1 = new int[256];
		int[] c2 = new int[256];

		for (int i = 0; i < s1.length(); i++) {
			c1[s1.charAt(i)]++;
		}
		for (int i = 0; i < s2.length(); i++) {
			c2[s2.charAt(i)]++;
		}

		for (int i = 0; i < c2.length; i++) {
			if (c1[i] != c2[i]) {
				return false;
			}
		}

		return true;
	}

}
