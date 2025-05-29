package linkedlist;

public class ReverseLinkedListRecursive {

	static Node head;

	static class Node {

		Node next = null;
		int data;

		public Node(int d) {
			data = d;
		}
	}

	// A simple and tail recursive function to reverse
	// a linked list. prev is passed as NULL initially.
	public static Node reverseUtil(Node curr, Node prev) {

		/* If last node mark it head */
		if (curr.next == null) {
			head = curr;

			/* Update next to prev node */
			curr.next = prev;
			return null;
		}

		/* Save curr->next node for recursive call */
		Node next = curr.next;

		/* and update next .. */
		curr.next = prev;

		reverseUtil(next, curr);

		return head;
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
		Node list = new Node(9);
		list.next = new Node(1);
		list.next.next = new Node(2);
		list.next.next.next = new Node(3);
		list.next.next.next.next = new Node(4);
		list.next.next.next.next.next = new Node(5);
		list.next.next.next.next.next.next = new Node(6);
		list.next.next.next.next.next.next.next = new Node(7);
		list.next.next.next.next.next.next.next.next = new Node(8);

		System.out.println("Original Linked list ");
		printList(list);
		Node reverseList = reverseUtil(list, null);
		System.out.println("");
		System.out.println("");
		System.out.println("Reversed linked list ");
		printList(reverseList);
	}

}
