package treesAndgraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class DepthLevelLinkedList {

	class Node {

		Node root, left, right;
		int data;

		public Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public ArrayList<LinkedList<Node>> depthLevelLinkedList(Node root) {

		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		int level = 0;

		LinkedList<Node> list = new LinkedList<Node>();
		list.add(root);
		result.add(level, list);

		while (true) {
			list = new LinkedList<Node>();
			for (int i = 0; i < result.get(level).size(); i++) {

				Node n = result.get(level).get(i);
				if (n != null) {
					if (n.left != null) {
						list.add(n.left);
					}
					if (n.right != null) {
						list.add(n.right);
					}
				}
			}
			if (list.size() > 0) {
				result.add(level + 1, list);
			} else {
				break;
			}
			level++;
		}

		return result;
	}

}
