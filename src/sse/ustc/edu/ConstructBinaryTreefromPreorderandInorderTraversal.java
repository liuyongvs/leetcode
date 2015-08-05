package sse.ustc.edu;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	 private TreeNode buildTreeHelper(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, HashMap<Integer, Integer> map) {
	    	if (preL > preR || inL > inR) {
				return null;
			}
	    	TreeNode root = new TreeNode(preorder[preL]);
	    	int index = map.get(preorder[preL]);
	    	root.left = buildTreeHelper(preorder, preL + 1, index - inL + preL, inorder, inL, index - 1, map);
	    	root.right = buildTreeHelper(preorder, index - inL + preL + 1 , preR, inorder, index + 1, inR, map);
	    	return root;
	    }
	    public TreeNode buildTree(int[] preoder, int[] inorder) {
	    	if (preoder == null || inorder == null) {
				return null;
			}
	    	HashMap<Integer, Integer> map = new HashMap<>();
	    	for (int i = 0; i < inorder.length; i++) {
				map.put(inorder[i], i);
			}
	    	return buildTreeHelper(preoder, 0, preoder.length - 1, inorder, 0, inorder.length - 1, map);
	    }
}
