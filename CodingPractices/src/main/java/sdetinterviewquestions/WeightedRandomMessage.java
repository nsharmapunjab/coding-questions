package sdetinterviewquestions;

import java.util.Random;

//import org.testng.Assert;
//import org.testng.annotations.Test;

public class WeightedRandomMessage {

	// Algo
	// randomWeight = rand(1, sumOfWeights)
	// for each item in array
	// randomWeight = randomWeight - item.Weight
	// if randomWeight <= 0
	// break // done, we select this item

	public static void main(String[] args) {

		int[] w = { 50, 30, 60 };
		returnVersionNbr(w);

	}

	public static int returnVersionNbr(int[] w) {

		if (w.length == 0) {
			return -1;
		}

		int sum = 0;
		for (int i = 0; i < w.length; i++) {
			sum = sum + w[i];
		}

		int randomWeight = generateRandomInt(1, sum);
		for (int i = 0; i < w.length; i++) {
			randomWeight = randomWeight - w[i];
			if (randomWeight <= 0) {
				System.out.println("Selected Weight : " + w[i]);
				return w[i];
			}
		}
		return -1;
	}

	public static int generateRandomInt(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}

	// Test Cases :
	// 1. no elem in array
	// 2. single elem in array
	// 3. multiple elem in array
	// 4. same weighted elem in array

//	@Test
//	public void testCase1() {
//		int[] w = { 50, 30, 60 };
//		int randomSelection = returnVersionNbr(w);
//		Assert.assertTrue(randomSelection > 0);
//	}
//
//	@Test
//	public void testCase2() {
//		int[] w = { 30 };
//		int randomSelection = returnVersionNbr(w);
//		Assert.assertTrue(randomSelection > 0);
//	}
//
//	@Test
//	public void testCase3() {
//		int[] w = {};
//		int randomSelection = returnVersionNbr(w);
//		Assert.assertTrue(randomSelection < 0);
//	}
//
//	@Test
//	public void testCase4() {
//		int[] w = { 50, 50, 50 };
//		int randomSelection = returnVersionNbr(w);
//		Assert.assertTrue(randomSelection > 0);
//	}
}
