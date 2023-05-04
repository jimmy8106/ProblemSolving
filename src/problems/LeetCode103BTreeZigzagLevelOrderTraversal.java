package problems;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode103BTreeZigzagLevelOrderTraversal {
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
      int height = 0;
      Deque<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      while (!queue.isEmpty()) {
          int size = queue.size();
          List<Integer> level = new ArrayList<>();//廣度優先一層的值
          for (int i = 0; i < size; i++) {
              if (height%2==0) {//正常poll
                  TreeNode node = queue.pollFirst();
                  level.add(node.val);
                  //下一層與此層反向
                  if (node.left != null) {
                      queue.offerLast(node.left);
                  }
                  if (node.right != null) {
                      queue.offerLast(node.right);
                  }
              } else {//反向poll
                  TreeNode node = queue.pollLast();
                  level.add(node.val);
                  //下一層與此層反向
                  if (node.right != null) {
                      queue.offerFirst(node.right);
                  }
                      if (node.left != null) {
                      queue.offerFirst(node.left);
                  }
              }
          }
          height++;
          result.add(level);
      }
      return result;
  }
}
