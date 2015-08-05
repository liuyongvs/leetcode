package sse.ustc.edu;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;

        if(root.val == sum && root.left == null && root.right == null)
            return true;
        if(hasPathSum(root.left, sum - root.val) ||  hasPathSum(root.right, sum - root.val))
            return true;
        else
            return false;
}
