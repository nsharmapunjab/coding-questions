package sdetinterviewquestions4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class HorizontalDistanceCounter {

    static class NodeHD {
        TreeNode node;
        int hd;
        NodeHD(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }


    public static int countRepeatedHorizontalDistances(TreeNode root) {
        if (root == null) return 0;

        // Map to store frequency of each HD
        Map<Integer, Integer> hdCount = new HashMap<>();
        Queue<NodeHD> queue = new LinkedList<>();
        queue.offer(new NodeHD(root, 0));

        while (!queue.isEmpty()) {
            NodeHD current = queue.poll();
            int hd = current.hd;

            hdCount.put(hd, hdCount.getOrDefault(hd, 0) + 1);

            if (current.node.left != null)
                queue.offer(new NodeHD(current.node.left, hd - 1));

            if (current.node.right != null)
                queue.offer(new NodeHD(current.node.right, hd + 1));
        }

        // Count HDs that occur more than once
        int result = 0;
        for (int count : hdCount.values()) {
            if (count > 1) result++;
        }

        return result;
    }

    // Sample tree builder and runner
    public static void main(String[] args) {
        /*
               1
             /   \
            2     3
           / \   / \
          4   5 6   7
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int result = countRepeatedHorizontalDistances(root);
        System.out.println("Number of repeated horizontal distances: " + result);
    }
}
