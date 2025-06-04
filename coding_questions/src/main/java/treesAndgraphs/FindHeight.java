package treesAndgraphs;

import java.util.Arrays;

public class FindHeight {

	// This function fills depth of i'th element in parent[]. The depth is
	// filled in depth[i].
	static void fillDepth(int parent[], int i, int depth[]) {

		// If depth[i] is already filled
		if (depth[i] != 0) {
			return;
		}

		// If node at index i is root
		if (parent[i] == -1) {
			depth[i] = 1;
			return;
		}

		// If depth of parent is not evaluated before, then evaluate
		// depth of parent first
		if (depth[parent[i]] == 0) {
			fillDepth(parent, parent[i], depth);
		}

		// Depth of this node is depth of parent plus 1
		depth[i] = depth[parent[i]] + 1;
	}

	// This function returns height of binary tree represented by
	// parent array
	static int findHeight(int parent[], int n) {

		// Create an array to store depth of all nodes/ and
		// initialize depth of every node as 0 (an invalid
		// value). Depth of root is 1
		int depth[] = new int[n];
		for (int i = 0; i < n; i++) {
			depth[i] = 0;
		}

		// fill depth of all nodes
		for (int i = 0; i < n; i++) {
			fillDepth(parent, i, depth);
		}

		// The height of binary tree is maximum of all depths.
		// Find the maximum value in depth[] and assign it to ht.
		System.out.println("Depth Array : " + Arrays.toString(depth));
		int ht = depth[0];
		for (int i = 1; i < n; i++) {
			if (ht < depth[i]) {
				ht = depth[i];
			}
		}
		return ht;
	}

	public static int maxDepth(int[] array) {
		int maxDepth = 0;
		int[] arrayCopy = new int[array.length];
		Arrays.fill(arrayCopy, 0);
		for (int i = 0; i < array.length; i++) {
			int j = array[i];
			if (j == -1) {
				arrayCopy[i] = 0;
			} else if (arrayCopy[j] > 0) {
				arrayCopy[i] = arrayCopy[j] + 1;
			} else {
				int count = 1;
				while (array[j] != -1 && arrayCopy[j] == 0) {
					j = array[j];
					count++;
				}
				arrayCopy[i] = arrayCopy[j] + count;
			}
			if (arrayCopy[i] > maxDepth)
				maxDepth = arrayCopy[i];
			// System.out.println(Arrays.toString(arrayCopy));
		}
		return maxDepth;
	}

	public static int heightoftree(int[] parent) {
		int max_height = Integer.MIN_VALUE;
		for (int i = 0; i < parent.length; i++) {
			int height = 1;
			int current = parent[i];
			while (current != -1) {
				height++;
				current = parent[current];
			}

			if (height > max_height) {
				max_height = height;
			}
		}

		return max_height;
	}

	// Driver program to test above functions
	public static void main(String args[]) {

		int parent1[] = { 1, 5, 5, 2, 2, -1, 3 };
		int parent2[] = { -1, 0, 0, 1, 1, 3, 5 };

		int n1 = parent1.length;
		int n2 = parent1.length;
		// System.out.println("Height is : " + findHeight(parent1, n1));
		// System.out.println("Height is  " + findHeight(parent2, n2));
		// System.out.println("Height is : " + maxDepth(parent1));
		// System.out.println("Height is : " + heightoftree(parent1));
		System.out.println("Height is : " + heightoftree(parent2));
	}

}
