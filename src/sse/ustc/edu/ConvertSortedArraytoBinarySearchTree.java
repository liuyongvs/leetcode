package sse.ustc.edu;

public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {
        if(start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTHelper(nums, start, mid - 1);
        root.right = sortedArrayToBSTHelper(nums, mid + 1, end);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        return sortedArrayToBSTHelper(nums, 0 , nums.length - 1);
    }
}
