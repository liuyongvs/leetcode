package sse.ustc.edu;

public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        if(head.val == head.next.val) {
            ListNode p = head.next.next;
            while(p != null) {
                if(head.val == p.val)
                    p = p.next;
                else
                    break;
            }
            return deleteDuplicates(p);
        }
            
        head.next = deleteDuplicates(head.next);
        return head;
    }
}
