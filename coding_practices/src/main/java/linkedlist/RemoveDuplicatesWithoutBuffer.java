package linkedlist;

public class RemoveDuplicatesWithoutBuffer {

	class Node {

		Node next = null;
		int data;

		public Node(int d) {
			data = d;
		}
	}

	public static void removeDuplicatesWithoutBuffer(Node n) {

		Node finalList = n;
		Node current = n.next;
		while (current != null) {
			Node runner = n;
			while (runner != current) {
				if (runner.data == current.data) {
					Node tmp = current.next;
					finalList.next = tmp;
					current = tmp;
					break;
				}
				runner = runner.next;
			}
			if (runner == current) {
				finalList.next = current;
				current = current.next;
			}
		}
	}

}
