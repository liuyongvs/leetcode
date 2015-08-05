package sse.ustc.edu;

public class ConvertSortedListtoBinarySearchTree {
	public ListNode getListMid(ListNode start, ListNode end) {
        if(start == end)
            return start;
        ListNode p1 = start;
        ListNode p2 = start;
        while(p1 != end && p1.next != end) {
            p1 = p1.next.next;
            p2 = p2.next;
        }
        return p2;
    }
    
    public TreeNode Helper(ListNode start, ListNode end) {
        if(start == end)
            return null;
        ListNode mid = getListMid(start, end);
        TreeNode root = new TreeNode(mid.val);
        root.left = Helper(start, mid);
        root.right = Helper(mid.next, end);
        return root;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        return Helper(head, null);
    }
}
