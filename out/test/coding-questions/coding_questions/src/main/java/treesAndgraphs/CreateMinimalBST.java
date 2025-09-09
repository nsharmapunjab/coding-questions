package treesAndgraphs;

public class CreateMinimalBST {

	static class Node {

		Node root, left, right;
		int data;

		public Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public static Node addToTree(int[] arr, int start, int end) {

		if (end < start) {
			return null;
		}

		int mid = (start + end) / 2;
		Node root = new Node(arr[mid]);
		root.left = addToTree(arr, start, mid - 1);
		root.right = addToTree(arr, mid + 1, end);

		return root;
	}

	public static Node createMinimalBST(int[] arr) {

		return addToTree(arr, 0, arr.length - 1);
	}
}
