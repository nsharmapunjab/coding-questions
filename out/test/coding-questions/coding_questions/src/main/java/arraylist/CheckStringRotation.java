package arraylist;

public class CheckStringRotation {

	public static void main(String[] args) {

		String s1 = "erbottlewat";
		String s2 = "waterbottle";

		System.out.println("String Rotation Result : "
				+ checkStringRotation(s1, s2));
	}

	public static boolean isSubstring(String s1, String s2) {

		return !(s1.indexOf(s2) == -1);
	}

	public static boolean checkStringRotation(String s1, String s2) {

		if (s1.length() == s2.length() && s1.length() > 0) {
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}

		return false;
	}

}
