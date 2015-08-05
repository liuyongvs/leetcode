package sse.ustc.edu;

public class BinarySearchTreeIterator {
	 private Queue<TreeNode> queue = new LinkedList<>();
	    
	    public void inorder(TreeNode root) {
	        if(root == null)
	            return;
	        inorder(root.left);
	        queue.add(root);
	        inorder(root.right);
	    }
	    public BSTIterator(TreeNode root) {
	        inorder(root);
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !queue.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	        TreeNode p = queue.poll();
	        int res = p.val;
	        return res;
	    }
}
