package linkedlist;

public class AddLists {

	class Node {

		Node next = null;
		int data;

		public Node(int d) {
			data = d;
		}
	}

	public Node addLists(Node l1, Node l2, int carry) {

		if (l1 == null && l2 == null) {
			return null;
		}
		int value = carry;
		if (l1 != null) {
			value += l1.data;
		}
		if (l2 != null) {
			value += l2.data;
		}
		Node result = new Node(value % 10);

		Node next = addLists(l1 == null ? null : l1.next, l2 == null ? null
				: l2.next, value >= 10 ? 1 : 0);

		result.next = next;

		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(10/10);
		System.out.println(10%10);
	}

}
