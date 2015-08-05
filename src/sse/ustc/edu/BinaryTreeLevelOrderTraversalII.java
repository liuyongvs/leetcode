package sse.ustc.edu;

public class BinaryTreeLevelOrderTraversalII {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
	public void levelOrderHelper(List<Integer> list, TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			list.add(root.val);
		}
		levelOrderHelper(list, root.left, level - 1);
		levelOrderHelper(list, root.right, level - 1);
	}
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}
		int height = maxDepth(root);
		for (int level = 1; level <= height; level++) {
			List<Integer> list = new ArrayList<>();
			levelOrderHelper(list, root, level);
			res.add(new ArrayList<>(list));
			list.clear();
		}
		
		List<List<Integer>> reverse = new ArrayList<>();
		for (int i = res.size() - 1; i >= 0; i--) {
			reverse.add(res.get(i));
		}
		return reverse;
	}
}
