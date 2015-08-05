package sse.ustc.edu;

public class PathSumII {
	public void pathSumHelper(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
        if(root == null)
            return ;
        list.add(root.val);
        if(root.left ==null && root.right == null && root.val == sum) {
            res.add(new ArrayList(list));
        }
        pathSumHelper(res, list, root.left, sum - root.val);
        pathSumHelper(res, list, root.right, sum - root.val);
        list.remove(list.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        List<Integer> list = new ArrayList<>();
        pathSumHelper(res, list, root, sum);
        return res;
}
