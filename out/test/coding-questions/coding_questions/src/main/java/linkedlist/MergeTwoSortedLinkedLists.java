package linkedlist;


public class MergeTwoSortedLinkedLists {

	static class Node {

		Node next;
		int data;

		public Node(int d) {
			data = d;
		}
	}

	static Node merge(Node a, Node b) {

		Node tmp, head;

		if (a == null) {
			return b;
		} else if (b == null) {
			return a;
		}

		if (a.data < b.data) {
			tmp = a;
			a = a.next;
		} else {
			tmp = b;
			b = b.next;
		}

		head = tmp;

		while (true) {

			if (a == null) {
				tmp.next = b;
				break;
			} else if (b == null) {
				tmp.next = a;
			} else if (a.data < b.data) {
				tmp.next = a;
				tmp = tmp.next;
				a = a.next;
			} else if (a.data > b.data) {
				tmp.next = b;
				tmp = tmp.next;
				b = b.next;
			}
		}

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
		Node list = new Node(1);
		list.next = new Node(2);
		list.next.next = new Node(4);
		list.next.next.next = new Node(6);
		list.next.next.next.next = new Node(7);

		Node list2 = new Node(3);
		list2.next = new Node(5);
		list2.next.next = new Node(8);
		list2.next.next.next = new Node(9);

		System.out.println("Original Linked lists ");
		printList(list);
		System.out.println("\n");
		printList(list2);
		Node mergedList = merge(list, list2);
		System.out.println("");
		System.out.println("");
		System.out.println("Reversed linked list ");
		printList(mergedList);
	}

}
