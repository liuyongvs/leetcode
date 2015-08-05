package sse.ustc.edu;

public class BinaryTreeMaximumPathSum {
	public int maxPathSumHelper(TreeNode root, int[] max) {
        if(root == null)
            return 0;
        int left = maxPathSumHelper(root.left, max);
        int right = maxPathSumHelper(root.right, max);
        int all = left + right + root.val;
        int current = Math.max((Math.max(left, right) + root.val), root.val);
        int maxFromLeftToRight = Math.max(current, all);
        if(maxFromLeftToRight > max[0])
            max[0] = maxFromLeftToRight;
        return current;
    }
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSumHelper(root, max);
        return max[0];
    }
}
