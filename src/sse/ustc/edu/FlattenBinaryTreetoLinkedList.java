package sse.ustc.edu;

public class FlattenBinaryTreetoLinkedList {
	//solution 1
	private TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        TreeNode right = root.right;
        if(pre != null) {
            pre.left = null;
            pre.right = root;
        }
        pre = root;
        flatten(root.left);
        flatten(right);
    }
    
  //solution 2
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left != null) {
            root.left = null;
            root.right = left;
            TreeNode p = left;
            while(p.right != null) {
                p = p.right;
            }
            p.right = right;
        }
        
        flatten(root.right);
    }
    
  //solution 3
    private void getPreorder(List<TreeNode> list, TreeNode root) {
        if(root == null)
            return;
        list.add(root);
        getPreorder(list, root.left);
        getPreorder(list, root.right);
    }
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        List<TreeNode> preorder = new ArrayList<>();
        getPreorder(preorder, root);
        int size = preorder.size();
        for(int i = 0; i< size - 1; i++) {
            preorder.get(i).left = null;
            preorder.get(i).right = preorder.get(i + 1);
        }
        TreeNode p = preorder.get(size - 1);
        p.left = null;
        p.right = null;
    }
}
