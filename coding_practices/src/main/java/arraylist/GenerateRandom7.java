package arraylist;

public class GenerateRandom7 {

	public static void main(String[] args) {

	}

	// generate random7 if random5 is available
	public static int generateRandom7() {

		while (true) {
			int num = 0;
			// int num = 5 * (rand5() - 1 + rand5() - 1);
			if (num < 21) {
				return (num % 7 + 1);
			}
		}
	}

}
