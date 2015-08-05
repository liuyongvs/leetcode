package sse.ustc.edu;

public class ValidateBinarySearchTree {
	//solution 1:
	long pre = Long.MIN_VALUE;
    public boolean isValidBSTHelper(TreeNode root)
    {
        if(root == null)
            return true;
        if(isValidBSTHelper(root.left))
        {
             if(root.val > pre)
             {
                 pre = root.val;
                 return isValidBSTHelper(root.right);
             }
             else
                return false;
        }
        else
            return false;
       
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root);
    }
    
  //solution 2:
    public boolean isValidBSTHelper(TreeNode root, long low, long high)
    {
        if(root == null)
            return true;
        if(root.val > low && root.val < high)
            return isValidBSTHelper(root.left, low, root.val) && isValidBSTHelper(root.right, root.val , high);
        else
            return false;
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    
}
