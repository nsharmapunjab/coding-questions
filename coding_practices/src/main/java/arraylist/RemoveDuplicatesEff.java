package arraylist;

public class RemoveDuplicatesEff {

	public static void main(String[] args) {

		String str = "nitin";
		System.out.println("Final String : " + removeDuplicatesEff(str));
	}

	public static String removeDuplicatesEff(String str) {

		if (str == null) {
			return null;
		}
		int len = str.length();
		if (len < 2) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		boolean[] hit = new boolean[256];

		for (int i = 0; i < len; i++) {
			if (!hit[str.charAt(i)]) {
				sb.append(str.charAt(i));
				hit[str.charAt(i)] = true;
			}
		}

		return sb.toString();
	}
}
