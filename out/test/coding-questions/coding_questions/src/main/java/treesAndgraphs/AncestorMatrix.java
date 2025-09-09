package treesAndgraphs;

import java.util.Arrays;

public class AncestorMatrix {

	static int[][] mat = new int[6][6];
	static int n = 6;

	static class Node {

		Node root, left, right;
		int data;

		public Node(int d) {
			data = d;
			left = right = null;
		}
	}

	// TODO :- This solution not working
	public static void findAncestorMatrix(Node root) {

		if (root != null) {
			// If left child is not null
			if (root.left != null) {
				int j = root.data;
				int k = root.left.data;
				// As root is ancestor of child
				mat[j][k] = 1;
				// All ancestor of root are ancestor of child also
				for (int i = 0; i < n; i++) {
					if (mat[i][j] == 1)
						mat[i][k] = 1;
				}
				findAncestorMatrix(root.left);
			}
			// Same for right child
			if (root.right != null) {
				int j = root.data;
				int k = root.right.data;
				mat[j][k] = 1;
				for (int i = 0; i < n; i++) {
					if (mat[i][j] == 1)
						mat[i][k] = 1;
				}
				findAncestorMatrix(root.right);
			}
		}
	}

	public static void main(String[] args) {

		Node root = new Node(5);
		root.left = new Node(1);
		root.right = new Node(2);
		root.left.left = new Node(0);
		root.left.right = new Node(4);
		root.right.left = new Node(2);

		System.out.println("Output matrix : " + Arrays.deepToString(mat));
	}

}
