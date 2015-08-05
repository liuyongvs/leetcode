package sse.ustc.edu;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	 private TreeNode buildTreeHelper(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR, HashMap<Integer, Integer> map){
	        if(inL > inR || postL > postR)
	            return null;
	        TreeNode root = new TreeNode(postorder[postR]);
	        int index = map.get(postorder[postR]);
	        root.left = buildTreeHelper(inorder, inL, index - 1, postorder, postL, index - inL + postL - 1, map);
	        root.right = buildTreeHelper(inorder, index + 1, inR, postorder, index - inL + postL, postR - 1, map);
	        return root;
	    }
	    public TreeNode buildTree(int[] inorder, int[] postorder) {
	        if(inorder == null || postorder == null ||inorder.length != postorder.length)
	            return null;
	        HashMap<Integer, Integer> map = new HashMap<>();
	        for(int i = 0; i < inorder.length; i ++){
	            map.put(inorder[i], i);
	        }
	        
	        return buildTreeHelper(inorder, 0 , inorder.length - 1, postorder, 0, postorder.length - 1, map);
	    }
}
