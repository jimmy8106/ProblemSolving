package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode102BTreeLevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode t = new TreeNode(3);
		t.left = new TreeNode(9);
		t.right = new TreeNode(20);
		t.left.left = new TreeNode(15);
		t.left.right = new TreeNode(7);

		System.out.println(levelOrder(t));
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      if (root == null) {
          return result;
      }
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      while (!queue.isEmpty()) {
          int size = queue.size();
          List<Integer> level = new ArrayList<>();//廣度優先一層的值
          for (int i = 0; i < size; i++) {
              TreeNode node = queue.poll();
              level.add(node.val);
              if (node.left != null) {
                  queue.offer(node.left);
              }
              if (node.right != null) {
                  queue.offer(node.right);
              }
          }
          result.add(level);
      }
      return result;
  }
}
