package sse.ustc.edu;

public class BinaryTreeRightSideView {
	public void rightSideViewHelper(HashMap<Integer, Integer> map, TreeNode root, int level) {
        if(root == null)
            return;
        map.put(level, root.val);
        rightSideViewHelper(map, root.left, level + 1);
        rightSideViewHelper(map, root.right, level + 1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        rightSideViewHelper(map, root, 0);
        return new ArrayList<Integer>(map.values());
    }
}
