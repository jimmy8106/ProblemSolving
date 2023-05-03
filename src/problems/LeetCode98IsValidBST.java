package problems;

public class LeetCode98IsValidBST {
  public static void main(String[] args) {
    TreeNode testCase = new TreeNode(2147483647);
    isValidBST(testCase);
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

  public static boolean isValidBST(TreeNode root) {
    return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE + 1);
  }

  static boolean helper(TreeNode root, Integer min, Integer max) {
    if (root == null)
      return true;
    System.out.println("min:" + min + " max:" + max + "node val:" + root.val);
    boolean a = root.val <= min;
    boolean b = root.val >= max;
    System.out.println("root.val <= min:" + a + " root.val >= max:" + b);
    if ((root.val <= min) || (root.val >= max))
      return false;

    return helper(root.left, min, root.val) && helper(root.right, root.val, max);
  }
}
