package sse.ustc.edu;

public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int leftHeight = 0;
        int rightHeight = 0;
        TreeNode p = root;
        while(p != null){
            leftHeight ++;
            p = p.left;
        }
        p = root;
        while(p != null) {
            rightHeight ++;
            p = p.right;
        }
        if(leftHeight == rightHeight)
            return (1 << leftHeight) - 1;
        else
            return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
