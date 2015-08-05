package sse.ustc.edu;

public class BinaryTreePreorderTraversal {
	 public List<Integer> preorderTraversal(TreeNode root) {
	        List<Integer> res = new ArrayList();
	        preorderTraversalHelper(res, root);
	        return res;
	    }
	    
	    public void preorderTraversalHelper(List<Integer> list, TreeNode root) {
	        if(root == null)
	            return;
	        list.add(root.val);
	        preorderTraversalHelper(list, root.left);
	        preorderTraversalHelper(list, root.right);
	    }
}
