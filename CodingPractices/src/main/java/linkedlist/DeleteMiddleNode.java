package linkedlist;

public class DeleteMiddleNode {

	class Node {

		Node next = null;
		int data;

		public Node(int d) {
			data = d;
		}
	}

	public static boolean deleteNode(Node n) {

		if (n == null) {
			return false;
		}

		if (n.next == null) {
			n = null;
		}

		n.data = n.next.data;
		n.next = n.next.next;
		return true;
	}

}
