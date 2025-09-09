package linkedlist;

public class ReverseEveryKNodes {

	static Node head;

	static class Node {

		Node next = null;
		int data;

		public Node(int d) {
			data = d;
			next = null;
		}
	}

	static Node reverse(Node head, int k) {
		Node current = head;
		Node next = null;
		Node prev = null;

		int count = 0;

		/* Reverse first k nodes of linked list */
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list
		 * starting from current. And make rest of the list as next of first
		 * node
		 */
		if (next != null)
			head.next = reverse(next, k);

		// prev is now head of input list
		return prev;
	}

	/* Utility functions */

	/* Inserts a new Node at front of the list. */
	public static void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	/* Function to print linked list */
	static void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Drier program to test above functions */
	public static void main(String args[]) {
		head = new Node(10);

		/*
		 * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
		 */
		push(9);
		push(8);
		push(7);
		push(6);
		push(5);
		push(4);
		push(3);
		push(2);
		push(1);

		System.out.println("Given Linked List");
		printList();

		head = reverse(head, 3);

		System.out.println("Reversed list");
		printList();
	}

}
