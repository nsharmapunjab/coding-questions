package linkedlist;

public class FindMidNode {

	static class Node {

		Node next;
		int data;

		public Node(int d) {
			data = d;
			next = null;
		}
	}

	public static Node findMidNode(Node head) {

		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return null;
		}

		Node n1 = head;
		Node n2 = head;

		while (n2 != null && n2.next != null) {
			n1 = n1.next;
			n2 = n2.next.next;
		}

		return n1;
	}

	public static void main(String[] args) {

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		System.out.println("Mid Node : " + findMidNode(head).data);
	}

}
