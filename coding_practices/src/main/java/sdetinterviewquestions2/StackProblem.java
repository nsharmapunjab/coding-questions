package sdetinterviewquestions2;

import java.util.Arrays;

public class StackProblem {

	/*
	 * Consider a stack of N number of cards which are piled up and in facing
	 * down. Each card has a unique number from the range 1 to N. The card is
	 * stacked in such a way that it exhibits the following behavior: Take the
	 * first card and put it under the stack without revealing. Now the next
	 * card on the top will have the number 1 on it. Next take 2 cards one after
	 * the other and put is under the stack without revealing. Yes you guessed
	 * it right - the next card on the top will reveal a value of 2. This goes
	 * on. Eg. for such a series : 9,1,8,5,2,4,7,6,3,10 [for N=10] Write a
	 * program to generate such a series for a given N number of cards so that
	 * this behavior can be exercised.
	 */
	public static void main(String[] args) {

		String arr[] = new String[10];
		int pointer = 0;
		for (int valueToPlace = 1; valueToPlace <= arr.length; valueToPlace++) {
			for (int x = 1; x <= valueToPlace; x++) {
				if (pointer == arr.length - 1)
					pointer = 0;
				else
					pointer++;
				if (arr[pointer] != null)
					x--;
			}
			System.out.println("Placing " + valueToPlace + " at index "
					+ pointer);
			arr[pointer] = valueToPlace + "";
			System.out.println("Arr  " + Arrays.toString(arr));
			while (arr[pointer] != null && valueToPlace != arr.length) {
				if (pointer == arr.length - 1)
					pointer = 0;
				else
					pointer++;
			}
		}
		for (String str : arr) {
			System.out.print(str + ", ");
		}
	}
}
