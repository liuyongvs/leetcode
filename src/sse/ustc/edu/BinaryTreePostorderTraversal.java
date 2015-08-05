package sse.ustc.edu;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode pre = null;
        while(!s.isEmpty()) {
            TreeNode cur = s.peek();
            if((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right) ))
            {
                TreeNode p = s.pop();
                res.add(p.val);
                pre = p;
            }
            else
            {
                if(cur.right != null)
                    s.push(cur.right);
                if(cur.left != null)
                    s.push(cur.left);
            }
            
        }
        
        return res;
    }
    
}
