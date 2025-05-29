package treesAndgraphs;

public class MirrorTree {

	class Node {

		Node root, left, right;
		int data;

		public Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public boolean findMirrorTree(Node a, Node b) {

		if (a == null && b == null) {
			return true;
		} else if (a == null || b == null) {
			return false;
		}

		return a.data == b.data && findMirrorTree(a.left, b.left)
				&& findMirrorTree(a.right, b.right);
	}

}
