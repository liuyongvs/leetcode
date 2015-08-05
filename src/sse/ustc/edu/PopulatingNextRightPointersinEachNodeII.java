package sse.ustc.edu;

public class PopulatingNextRightPointersinEachNodeII {
	public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        TreeLinkNode p = root.next;
        while(p != null) {
            if(p.left != null)
            {
                p = p .left;
                break;
            }
            if(p.right != null)
            {
                p = p.right;
                break;
            }
            p = p.next;
            
        }
        
        if(root.left != null) {
            root.left.next = (root.right == null? p:root.right);
        }
        if(root.right != null) {
            root.right.next = p;
        }
        /*here must first traverse right, then traverse left, or the p (find next) will not be the right pointer we want*/
        connect(root.right);
        connect(root.left);
       
        
    }
}
