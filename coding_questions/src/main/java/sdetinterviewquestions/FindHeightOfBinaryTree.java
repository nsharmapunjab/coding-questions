package sdetinterviewquestions;

import java.util.ArrayList;
import java.util.LinkedList;

public class FindHeightOfBinaryTree {

	static class Node {

		Node root, left, right;
		int data;

		public Node(int d) {
			data = d;
		}
	}

	public static int findHeightOfTree(Node root) {

		if (root == null) {
			return 0;
		}

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

		return result.size()-1;

	}
	
	//Test Cases
	//1. root is null
	//2. only root is available
	//3. root with left and right only
	//4. root with left only
	//5. root with right only
	//6. root with nested left and right nodes
	//7. root with one left and nested right nodes
	//8. root with one right and nested left nodes

}
