package sse.ustc.edu;

public class RecoverBinarySearchTree {
	public void recoverTreeHelper(TreeNode root, List<TreeNode> res) {
        if(root == null)
            return;
        recoverTreeHelper(root.left, res);
        res.add(root);
        recoverTreeHelper(root.right, res);
        
    }
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        List<TreeNode> res = new ArrayList<>();
        recoverTreeHelper(root, res);
        TreeNode p1 = null;
        TreeNode p2 = null;
        for(int i = 0; i < res.size() - 1; i++) {
            if(res.get(i).val > res.get(i + 1).val) {
                if(p1 == null) {
                    p1 = res.get(i);
                    p2 = res.get(i + 1);
                }
                else
                    p2 = res.get(i + 1);
            }
        }
        
        //exchange data
        int temp = p1.val;
        p1.val = p2.val;
        p2.val = temp;
    }
}
