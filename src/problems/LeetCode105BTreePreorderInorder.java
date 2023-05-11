package problems;

import java.util.Arrays;
import java.util.Stack;
import problems.TreeNodeUtils.TreeNode;;

public class LeetCode105BTreePreorderInorder {
  public static void main(String[] args) {
    int[] preorder = { 3, 9, 20, 15, 7 };
    int[] inorder = { 9, 3, 15, 20, 7 };
//		TreeNode node = buildTree(preorder, inorder);
//		System.out.println("yes");

    TreeNode a = new TreeNode(3);
    a.left = new TreeNode(9);
    a.left.right = new TreeNode(11);
    a.right = new TreeNode(20);
    a.right.left = new TreeNode(15);
    a.right.right = new TreeNode(7);
    System.out.print("in:");
    TreeNodeUtils.printInorder(a);
    System.out.println();
    System.out.print("pre:");
    TreeNodeUtils.printPreorder(a);

  }

  public static TreeNode buildTree(int[] preorder, int[] inorder) {
    int n = preorder.length;
    if (n != inorder.length) {
      return null;
    }
    if (n == 0) {
      return null;
    }
    if (n == 1) {
      return new TreeNode(preorder[0]);
    }
    //get root node
    TreeNode node = new TreeNode(preorder[0]);
    int pos = 0;
    // find position in inorder
    for (int i = 0; i < inorder.length; i++) {
      if (node.val == inorder[i]) {
        pos = i;
        break;
      }
    }
    // i代表左子樹為止有幾個node 故 pre[1,i]是左子樹
    node.left = buildTree(Arrays.copyOfRange(preorder, 1, pos + 1), Arrays.copyOfRange(inorder, 0, pos));
    node.right = buildTree(Arrays.copyOfRange(preorder, pos + 1, n), Arrays.copyOfRange(inorder, pos + 1, n));
    return node;

  }

  public static TreeNode buildTrees(int[] preorder, int[] inorder) {
    if (preorder.length == 0) {
      return null;
    }
    Stack<TreeNode> roots = new Stack<TreeNode>();// keep already traversed nodes
    int pre = 0;
    int in = 0;
    // root from preorder[0]
    TreeNode curRoot = new TreeNode(preorder[pre]);
    TreeNode root = curRoot;
    roots.push(curRoot);
    pre++;
    // traverse preorder array
    while (pre < preorder.length) {
      // if current root equal preorder value
      if (curRoot.val == inorder[in]) {
        while (!roots.isEmpty() && roots.peek().val == inorder[in]) {
          curRoot = roots.peek();
          roots.pop();
          in++;
        }
        curRoot.right = new TreeNode(preorder[pre]);
        curRoot = curRoot.right;
        roots.push(curRoot);
        pre++;
      } else {
        curRoot.left = new TreeNode(preorder[pre]);
        curRoot = curRoot.left;
        roots.push(curRoot);
        pre++;
      }
    }
    return root;
  }

}
