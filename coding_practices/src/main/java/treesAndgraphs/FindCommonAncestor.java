package treesAndgraphs;

public class FindCommonAncestor {

	class Node {

		Node root, left, right;
		int data;

		public Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public Node findCommonAncestor(Node root, Node firstNode, Node secondNode) {

		if (root == null) {
			return null;
		}

		if (isChildOfTree(root.left, firstNode)
				&& isChildOfTree(root.left, secondNode)) {
			return findCommonAncestor(root.left, firstNode, secondNode);
		}
		if (isChildOfTree(root.right, firstNode)
				&& isChildOfTree(root.right, secondNode)) {
			return findCommonAncestor(root.right, firstNode, secondNode);
		}

		return root;
	}

	public boolean isChildOfTree(Node root, Node child) {

		if (root == null) {
			return false;
		}
		if (root == child) {
			return true;
		}
		return isChildOfTree(root.left, child)
				|| isChildOfTree(root.right, child);
	}

}
