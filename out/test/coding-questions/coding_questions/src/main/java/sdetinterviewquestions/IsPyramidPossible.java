package sdetinterviewquestions;

public class IsPyramidPossible {

	public static void main(String[] args) {
		System.out.println(String.format("Input: %d, Possible: %s", 4,
				isPyramidPossible(4)));
		System.out.println(String.format("Input: %d, Possible: %s", 9,
				isPyramidPossible(9)));
		System.out.println(String.format("Input: %d, Possible: %s", 6,
				isPyramidPossible(6)));
	}

	public static boolean isPyramidPossible(int bricks) {
		int rowBricks = 1;
		while (bricks > 0) {
			bricks -= rowBricks;
			rowBricks += 2;
		}

		return bricks == 0;
	}

}
