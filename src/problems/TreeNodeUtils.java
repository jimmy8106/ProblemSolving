package problems;

public class TreeNodeUtils {
  public static void printInorder(TreeNode node) {
    if (node == null)
      return;

    /* first recur on left child */
    printInorder(node.left);

    /* then print the data of node */
    System.out.print(node.val + " ");

    /* now recur on right child */
    printInorder(node.right);
  }

  public static void printPreorder(TreeNode node) {
    if (node == null)
      return;

    /* first print data of node */
    System.out.print(node.val + " ");

    /* then recur on left subtree */
    printPreorder(node.left);

    /* now recur on right subtree */
    printPreorder(node.right);
  }
  
  public static void printPostorder(TreeNode node)
  {
      if (node == null)
          return;

      // first recur on left subtree
      printPostorder(node.left);

      // then recur on right subtree
      printPostorder(node.right);

      // now deal with the node
      System.out.print(node.val + " ");
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
}
