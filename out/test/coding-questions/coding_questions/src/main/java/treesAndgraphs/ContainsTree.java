package treesAndgraphs;

public class ContainsTree {

	class Node {

		Node root, left, right;
		int data;

		public Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public boolean containsTree(Node n1, Node n2) {

		if (n2 == null) {
			return true; // The empty tree is always a subtree
		} else {
			return subTree(n1, n2);
		}
	}

	public boolean subTree(Node n1, Node n2) {

		if (n1 == null) {
			return false; // big tree empty and subtree still not found
		}

		if (n1.data == n2.data) {
			if (matchTree(n1, n2)) {
				return true;
			}
		}

		return (subTree(n1.left, n2) || subTree(n1.right, n2));
	}

	public boolean matchTree(Node n1, Node n2) {

		if (n1 == null && n2 == null) {
			return true; // nothing left in the subtree
		}
		if (n1 == null || n2 == null) {
			return false; // bigtree empty and subtree still not found
		}

		if (n1.data != n2.data) {
			return false; // data doesn't match
		}

		return (matchTree(n1.left, n2.left) && matchTree(n1.right, n2.right));
	}

}
