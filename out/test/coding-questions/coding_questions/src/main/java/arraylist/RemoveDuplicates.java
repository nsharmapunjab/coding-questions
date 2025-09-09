package arraylist;

public class RemoveDuplicates {

	public static void main(String[] args) {

		String str = "nitin";
		System.out.println("Original String : " + str);
		System.out.println("Final String : " + removeDuplicates(str));

	}

	public static String removeDuplicates(String str) {

		if (str == null) {
			return null;
		}
		int len = str.length();
		if (len < 2) {
			return null;
		}

		String s = "";

		for (int i = 0; i < len; i++) {
			if (s.indexOf(str.charAt(i)) == -1) {
				s = s + str.charAt(i);
			}
		}

		return s;
	}

}
