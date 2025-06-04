package linkedlist;


public class RearrangeOddEven {

	class Node {

		Node next;
		int data;

		public Node(int d) {
			data = d;
			next = null;
		}
	}

	public Node rearrangeEvenOdd(Node head) {

		if (head.next == null) {
			return head;
		}

		Node odd, even, even_head, itr;
		odd = head;
		even = even_head = head.next;
		itr = even.next;
		boolean isOdd = true;

		while (itr != null) {
			if (isOdd) {
				odd.next = itr;
				odd = itr;
			} else {
				even.next = itr;
				even = itr;
			}
			itr = itr.next;
			isOdd = !isOdd;
		}

		odd.next = even_head;
		even.next = null;

		return head;
	}

}
