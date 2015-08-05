package sse.ustc.edu;

public class LowestCommonAncestorofaBinaryTree {
	 //solution 1: save the path, time complexity is O(n), we will need to traverse 
		// almost the tree three times 
	    private boolean getNodePath(TreeNode root, TreeNode p, List<TreeNode> path) {
		        if(root == null)
		            return false;
		        path.add(root);
		        if(p == root)
		            return true;
		        if (getNodePath(root.left, p, path)) {
					return true;
				}
		        if (getNodePath(root.right, p, path)) {
					return true;
				}   
		        path.remove(path.size() - 1);
				return false;
		    }
		    
		    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		        if(root == null || p == null || q == null)
		            return null;
		        List<TreeNode> path1 = new ArrayList<>();
		        List<TreeNode> path2 = new ArrayList<>();
		        
		        getNodePath(root, p, path1);
		        getNodePath(root, q, path2);
		        
		        TreeNode res = null;
		        for(int i = 0; i < path1.size() && i < path2.size(); i++) {
		        	res = path1.get(i);
		            if(path1.get(i) != path2.get(i)) {
		            	res = path1.get(i - 1);
		            	break;
		            }
		                
		        }
		        return res;
		    }


	    //solution 2: top-down approach, we assume both the p q are in the tree, if not we can write a function
	    //to check the tree. but the time complexity is O(n^2), will be time exceeding error
//	 	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//	 		if (root == null || p == null || q == null) {
//	 			return null;
//	 		}
//	 		return getlowestCommonAncestor(root, p, q);
			
//	 	}
		
//	 	private TreeNode getlowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//	 		if (root == null) {
//	 			return null;
//	 		}
//	 		if (root == p || root == q) {
//	 			return root;
//	 		}
//	 		TreeNode left = getlowestCommonAncestor(root.left, p, q);
//	 		TreeNode right = getlowestCommonAncestor(root.right, p, q);
//	 		//if we can both find the element in the left subtree and the right subtree
//	 		//so the element is the lowest common ancestor
//	 		if (left != null && right != null) {
//	 			return root;
//	 		}
//	 		if (left == null) {
//	 			return getlowestCommonAncestor(root.right, p, q);
//	 		}
			
//	 		if (right == null) {
//	 			return getlowestCommonAncestor(root.left, p, q);
//	 		}
//	 		return null;
//	 	}
}
