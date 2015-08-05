package sse.ustc.edu;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;

        while(cur != null || !s.isEmpty()) {
            while(cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            if(!s.isEmpty()){
                TreeNode p = s.peek();
                res.add(p.val);
                s.pop();
                cur = p.right;
            }
        }
        return res;
    }
}
