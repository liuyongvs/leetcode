package sse.ustc.edu;

public class InvertBinaryTree {
	public void invertTreeHelper(TreeNode root) {
        if(root == null)
            return ;
        
        
        invertTreeHelper(root.left);
        invertTreeHelper(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        invertTreeHelper(root);
        return root;
    }
}
