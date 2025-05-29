package arraylist;

public class IsUniqueChars {

	public static void main(String[] args) {

		String str = "nitin";
		System.out.println("Checking isUnique Chars : " + isUniqueChars(str));
	}

	public static boolean isUniqueChars(String str) {

		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}

}
