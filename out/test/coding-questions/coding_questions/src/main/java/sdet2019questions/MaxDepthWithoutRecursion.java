/**
 * 
 */
package sdet2019questions;

import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/**
 * @author Nitin Sharma
 *
 */
public class MaxDepthWithoutRecursion {

	class Node {

		Node root, left, right;
		int data;

		public Node(int d) {
			data = d;
		}
	}

	public int maxDepth(Node root) {
		if (root == null)
			return 0;
		LinkedList<Node> arr = new LinkedList<Node>(); // queue for current level
		LinkedList<Node> tmp = new LinkedList<Node>(); // queue for next level
		arr.add(root);
		int res = 0; // result
		Node node; // tmp node
		while (true) {
			while (!arr.isEmpty()) {
				node = arr.poll();
				if (node.left != null)
					tmp.add(node.left);
				if (node.right != null)
					tmp.add(node.right);
			}
			res++;
			if (tmp.isEmpty())
				break;
			arr = tmp;
			tmp = new LinkedList<Node>();
		}
		return res;
	}
}
