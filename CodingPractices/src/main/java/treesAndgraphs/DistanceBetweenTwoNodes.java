package treesAndgraphs;

public class DistanceBetweenTwoNodes {

	class Node {

		Node left;
		Node right;
		int data;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

	public int findDistance(Node root, int n1, int n2) {
		int x = Pathlength(root, n1) - 1;
		int y = Pathlength(root, n2) - 1;
		int lcaData = findLCA(root, n1, n2).data;
		int lcaDistance = Pathlength(root, lcaData) - 1;
		return (x + y) - 2 * lcaDistance;
	}

	public int Pathlength(Node root, int n1) {
		if (root != null) {
			int x = 0;
			if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0
					|| (x = Pathlength(root.right, n1)) > 0) {
				// System.out.println(root.data);
				return x + 1;
			}
			return 0;
		}
		return 0;
	}

	public Node findLCA(Node root, int n1, int n2) {
		if (root != null) {
			if (root.data == n1 || root.data == n2) {
				return root;
			}
			Node left = findLCA(root.left, n1, n2);
			Node right = findLCA(root.right, n1, n2);

			if (left != null && right != null) {
				return root;
			}
			if (left != null) {
				return left;
			}
			if (right != null) {
				return right;
			}
		}
		return null;
	}

	public static void main(String[] args) throws java.lang.Exception {
		DistanceBetweenTwoNodes mainClass = new DistanceBetweenTwoNodes();
		Node root = mainClass.new Node(5);
		root.left = mainClass.new Node(10);
		root.right = mainClass.new Node(15);
		root.left.left = mainClass.new Node(20);
		root.left.right = mainClass.new Node(25);
		root.right.left = mainClass.new Node(30);
		root.right.right = mainClass.new Node(35);
		root.left.right.right = mainClass.new Node(45);
		DistanceBetweenTwoNodes i = new DistanceBetweenTwoNodes();
		System.out.println("Distance between 45 and 20 is : "
				+ i.findDistance(root, 45, 20));
	}
}
