package linkedlist;

import java.util.Hashtable;

public class RemoveDuplicatesWithBuffer {

	class Node {

		Node next = null;
		int data;

		public Node(int d) {
			data = d;
		}
	}

	public static void removeDuplicatesWithBuffer(Node n) {

		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		Node previous = null;

		while (n.next != null) {
			if (table.containsKey(n.data)) {
				previous.next = n.next;
			} else {
				table.put(n.data, true);
				previous = n;
			}
			n = n.next;
		}
	}

}
