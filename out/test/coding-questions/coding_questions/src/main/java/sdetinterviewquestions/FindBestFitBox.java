package sdetinterviewquestions;

public class FindBestFitBox {

	public static void main(String[] args) {

		int[] a = { 10, 20, 30, 40, 50, 60, 70 };
		System.out.println("Best Fit Box : " + findBestFitBox(a, 50));
	}

	public static int findBestFitBox(int[] a, int x) {

		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				return x;
			} else if (a[i] > x) {
				return a[i];
			}
		}

		return -1;
	}

}
