package linkedlist;


public class ReverseLinkedListIterative {

	static class Node {

		Node next = null;
		int data;

		public Node(int d) {
			data = d;
		}
	}

	public static Node reverseList(Node head) {

		// 11->12->13->14->null
		// 14->13->12->11->null
		Node prev = null;
		Node next = null;
		Node current = head;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	// prints content of double linked list
	public static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.print("null ");
	}

	public static void main(String[] args) {
		Node list = new Node(10);
		list.next = new Node(85);
		list.next.next = new Node(15);
		list.next.next.next = new Node(4);
		list.next.next.next.next = new Node(20);

		System.out.println("Given Linked list");
		printList(list);
		Node reverseList = reverseList(list);
		System.out.println("");
		System.out.println("Reversed linked list ");
		printList(reverseList);
	}

}
