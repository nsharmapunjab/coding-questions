package linkedlist;

public class NthToLastNode {

	class Node {

		Node next = null;
		int data;

		public Node(int d) {
			data = d;
		}
	}

	public static Node findNthToLastNode(Node head, int n) {

		if (head == null || n < 1) {
			return null;
		}

		Node p1 = head;
		Node p2 = head;

		for (int i = 0; i < n - 1; i++) {
			p2 = p2.next;
		}

		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1;
	}

}
