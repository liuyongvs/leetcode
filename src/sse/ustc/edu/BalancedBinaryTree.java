package sse.ustc.edu;

public class BalancedBinaryTree {
	public int maxDepth(TreeNode root)
    {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if(Math.abs(l -r) <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        else
            return false;
            
    }
}
