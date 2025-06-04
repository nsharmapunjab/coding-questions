package linkedlist;

public class FindCircularNode {

	class Node {

		Node next = null;
		int data;

		public Node(int d) {
			data = d;
		}
	}

	public Node findCircularNode(Node n) {

		Node n1 = n;
		Node n2 = n;

		while (n2.next != null) {
			n1 = n1.next;
			n2 = n2.next.next;
			if (n1 == n2) {
				break;
			}
		}

		if (n2.next == null) {
			return null;
		}

		n1 = n;

		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}

		return n2;
	}

}
