package stackqueue;

public class ImplementQueue {

	class Node {

		Node next = null;
		int data;

		public Node(int d) {
			data = d;
		}
	}

	class Queue {

		Node first;
		Node last;

		void enqueue(int item) {

			if (first == null) {
				last = new Node(item);
				first = last;
			} else {
				last.next = new Node(item);
				last = last.next;
			}
		}

		Node dequeue() {
			Node item = first;
			first = first.next;
			return item;
		}
	}

}
