package problems;

public class LeetCode101SymmetricTree {
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.right = new TreeNode(2);
		t.left.left = new TreeNode(3);
		t.left.right = new TreeNode(4);
		t.right.left = new TreeNode(4);
		t.right.right = new TreeNode(3);

		System.out.println(isSymmetricTree(t.left, t.right));
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

	public static boolean isSymmetricTree(TreeNode t1, TreeNode t2) {
		return traverse(t1, t2);
	}

	static boolean traverse(TreeNode t1, TreeNode t2) {
		if (t1 != null && t2 == null || t1 == null && t2 != null) {
			return false;
		}
		if (t1 != null && t2 != null) {
			if (t1.val != t2.val) {
				return false;
			}
			return traverse(t1.left, t2.right) && traverse(t1.right, t2.left);
		}
		return true;
	}
}
