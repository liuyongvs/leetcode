package sse.ustc.edu;

public class PopulatingNextRightPointersinEachNode {
	 public void connect(TreeLinkNode root) {
	        if(root == null)
	            return;
	        if(root.left != null)
	            root.left.next = root.right;
	        if(root.right !=null)
	            root.right.next = (root.next == null? null: root.next.left);
	        connect(root.left);
	        connect(root.right);
	    }
}
