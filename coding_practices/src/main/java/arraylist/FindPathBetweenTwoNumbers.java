package arraylist;

public class FindPathBetweenTwoNumbers {

	public static void main(String[] args) {

		// find path between a to b
		// e.g 3->31->62->124->1241

		findPath(3, 1241);

		System.out.println(1242 % 10);
	}

	public static void findPath(int a, int b) {

		while (a < b) {
			if (b % 10 == 1) {
				b = b / 10;
			} else {
				b = b / 2;
			}
		}
		if (a == b) {
			System.out.println("Path found");
		} else {
			System.out.println("Path not found");
		}
	}

}
