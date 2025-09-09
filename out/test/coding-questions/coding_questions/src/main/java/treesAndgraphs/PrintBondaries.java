package treesAndgraphs;

public class PrintBondaries {

	static class Node {

		Node root, left, right;
		int data;

		public Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		
		Node root = new Node(20);
		root.left = new Node(8);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		root.right = new Node(22);
		root.right.right = new Node(25);
		
		traverseTree(root);

	}

	static void traverseTree(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		if (root.left != null) {
			traverseL(root.left);
		}
		if (root.right != null) {
			traverseR(root.right);
		}
	}

	static void traverseL(Node root) {

		System.out.println(root.data);
		if (root.left != null) {
			traverseL(root.left);
		}
		if (root.right != null) {
			traverseC(root.right);
		}
	}

	static void traverseR(Node root) {

		if (root.left != null) {
			traverseC(root.left);
		}
		if (root.right != null) {
			traverseR(root.right);
		}
		System.out.println(root.data);
	}

	static void traverseC(Node root) {

		if (root.left == null && root.right == null) {
			System.out.println(root.data);
		} else {
			if (root.left != null) {
				traverseC(root.left);
			}
			if (root.right != null) {
				traverseC(root.right);
			}
		}
	}

}
