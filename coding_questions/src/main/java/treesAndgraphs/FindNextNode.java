package treesAndgraphs;

public class FindNextNode {

	class Node {

		Node root, left, right;
		int data;

		public Node(int d) {
			data = d;
		}
	}

	public Node findNextNode(Node root) {

		if (root != null) {
			Node next = null;
			if (root.right != null) {
				next = root.right;
				while (next.left != null) {
					next = next.left;
				}
				return next;
			}

			else {
				while ((next = root.root) != null) {
					if (next.left == root) {
						return next;
					}
					root = next;
				}
				return next;
			}
		}

		return null;
	}

}
