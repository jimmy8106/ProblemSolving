package problems;

import java.util.Stack;

public class LeetCode105BTreePreorderInorder {
	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		TreeNode node = buildTree(preorder, inorder);
		System.out.println("yes");
		
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

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
	    if (preorder.length == 0) {
	        return null;
	    }
	    Stack<TreeNode> roots = new Stack<TreeNode>();//keep already traversed nodes
	    int pre = 0;
	    int in = 0;
	    //root from preorder[0]
	    TreeNode curRoot = new TreeNode(preorder[pre]);
	    TreeNode root = curRoot;
	    roots.push(curRoot);
	    pre++;
	    // traverse preorder array
	    while (pre < preorder.length) {
	    	//if current root equal preorder value
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
