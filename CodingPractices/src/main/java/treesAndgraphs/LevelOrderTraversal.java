package treesAndgraphs;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	static class Node {

		Node root, left, right;
		int data;

		public Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public static void main(String args[]) {
		/*
		 * creating a binary tree and entering the nodes
		 */
		BinaryTree tree_level = new BinaryTree();
		tree_level.root = new Node(1);
		tree_level.root.left = new Node(2);
		tree_level.root.right = new Node(3);
		tree_level.root.left.left = new Node(4);
		tree_level.root.left.right = new Node(5);
		tree_level.root.right.left = new Node(6);
		tree_level.root.right.right = new Node(7);

		System.out.println("Level order traversal of binary tree is - ");
		tree_level.printLevelOrder();
	}

	static class BinaryTree {

		Node root;

		/*
		 * Given a binary tree. Print its nodes in level order using array for
		 * implementing queue
		 */
		void printLevelOrder() {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			while (!queue.isEmpty()) {

				/*
				 * poll() removes the present head. For more information on
				 * poll() visit
				 * http://www.tutorialspoint.com/java/util/linkedlist_poll.htm
				 */
				Node tempNode = queue.poll();
				System.out.print(tempNode.data + " ");

				/* Enqueue left child */
				if (tempNode.left != null) {
					queue.add(tempNode.left);
				}

				/* Enqueue right child */
				if (tempNode.right != null) {
					queue.add(tempNode.right);
				}
			}
		}
	}

}
