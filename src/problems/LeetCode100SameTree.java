package problems;

public class LeetCode100SameTree {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(3);
		
		TreeNode t2 = new TreeNode(1);
		t2.left = new TreeNode(2);
		t2.right = new TreeNode(3);
		
		System.out.println(sameTree(t1,t2));
	}

	
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	
	  public static boolean sameTree(TreeNode t1,TreeNode t2) {
		  return traverse(t1, t2);
	    }
	    
	  static boolean traverse(TreeNode t1, TreeNode  t2) {
	        if (t1 == null && t2 ==null) {
	        	return true;
	        } else if (t1 == null || t2 ==null) {
	        	return false;
	        }
	        if (!traverse(t1.left, t2.left)) {
	        	return false;
	        }
	        if (t1.val!=t2.val) {
	        	return false;
	        }
	        if (!traverse(t1.right, t2.right)) {
	        	return false;
	        }
	        return true;
	    }
}
