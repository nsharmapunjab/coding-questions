package treesAndgraphs;

public class CheckBalancedTree {

	class Node {

		Node root, left, right;
		int data;

		public Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public static boolean isBalancedTree(Node root) {

		return (maxDepth(root) - minDepth(root) <= 1);
	}

	public static Integer maxDepth(Node root) {

		if (root == null) {
			return 0;
		}

		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	public static Integer minDepth(Node root) {

		if (root == null) {
			return 0;
		}

		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}
}
