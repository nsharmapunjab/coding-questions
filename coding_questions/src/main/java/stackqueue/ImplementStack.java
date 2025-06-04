package stackqueue;

public class ImplementStack {

	class Node {

		Node next = null;
		int data;

		public Node(int d) {
			data = d;
		}
	}

	class Stack {

		Node top;

		Node pop() {
			if (top != null) {
				Node item = top;
				top = top.next;
				return item;
			}
			return null;
		}

		void push(int d) {

			Node item = new Node(d);
			top.next = top;
			top = item;
		}
	}

}
