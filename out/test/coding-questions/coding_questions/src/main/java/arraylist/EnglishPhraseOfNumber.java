package arraylist;

public class EnglishPhraseOfNumber {

	public static void main(String[] args) {

		int num = 10345;
		System.out.println("English phrase of number : "
				+ englishPhraseOfNumber(num));
	}

	public static String englishPhraseOfNumber(int num) {

		StringBuilder sb = new StringBuilder();
		int len = 1;
		while (Math.pow(10, len) < num) {
			len++;
		}
		String[] wordarr1 = { "", "One ", "Two ", "Three ", "Four ", "Five ",
				"Six ", "Seven ", "Eight ", "Nine " };
		String[] wordarr11 = { "", "Eleven ", "Twelve ", "Thirteen ",
				"Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ",
				"Nineteen " };
		String[] wordarr10 = { "", "Ten ", "Twenty ", "Thirty ", "Fourty ",
				"Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety " };
		String[] wordarr100 = { "", "Hundred ", "Thousand " };

		int tmp;
		if (num == 0) {
			sb.append("Zero");
		} else {
			if (len > 3 && len % 2 == 0) {
				len++;
			}
			do {
				// Number greater then 999
				if (len > 3) {
					tmp = (int) (num / Math.pow(10, len - 2));
					if (tmp / 10 == 1 && tmp % 10 != 0) {
						sb.append(wordarr11[tmp % 10]);
					} else {
						sb.append(wordarr10[tmp / 10]);
						sb.append(wordarr1[tmp % 10]);
					}
					if (tmp > 0) {
						sb.append(wordarr100[len / 2]);
					}
					num = num % (int) (Math.pow((double) 10, (double) len - 2));
					len = len - 2;
				} else {
					tmp = num / 100;
					if (tmp != 0) {
						sb.append(wordarr1[tmp]);
						sb.append(wordarr100[len / 2]);
					}
					tmp = num % 100;
					if (tmp / 10 == 1 && tmp % 10 != 0) {
						sb.append(wordarr11[tmp % 10]);
					} else {
						sb.append(wordarr10[tmp / 10]);
						sb.append(wordarr1[tmp % 10]);
					}
					len = 0;
				}
			} while (len > 0);
		}

		return sb.toString();
	}
}
