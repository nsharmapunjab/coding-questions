package sdetinterviewquestions;

//import org.testng.Assert;
//import org.testng.annotations.Test;

public class KthLastElemLinkedList {

	static class Node {

		Node next;
		int data;

		public Node(int d) {
			data = d;
		}
	}

	public static Node findKthLastElem(Node root, int k) {

		if (root == null) {
			return null;
		}

		Node n1 = root;
		Node n2 = root;

		int count = 1;
		while (count < k) {
			n2 = n2.next;
			count++;
		}

		while (n2.next != null) {
			n2 = n2.next;
			n1 = n1.next;
		}

		return n1;
	}

//	@Test
	public void testEqualValue() {

		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(3);
		root.next.next.next = new Node(4);
		root.next.next.next.next = new Node(5);
		root.next.next.next.next.next = new Node(6);

//		Assert.assertEquals(findKthLastElem(root, 3).data, 4,
//				"Node elem not matching");

	}

	public static void main(String[] args) {

		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(3);
		root.next.next.next = new Node(4);
		root.next.next.next.next = new Node(5);
		root.next.next.next.next.next = new Node(6);

		System.out.println(findKthLastElem(root, 6).data);
	}

	// Test Cases
	// 1. only one elem
	// 2. k>no. of elem
	// 3. k<no. of elem
	// 4. k is in between no. of elem
	// 5. empty linked list
	// 6. k=0
	// 7. k is negative number
	// 8. k is positive number and list is null
	// 9.

}
