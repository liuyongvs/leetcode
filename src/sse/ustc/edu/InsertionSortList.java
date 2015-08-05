package sse.ustc.edu;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        
        ListNode cur = head;
        ListNode next = null;
        while(cur != null) {
            next = cur.next;
            while(pre.next != null && pre.next.val < cur.val)
                pre = pre.next;
            cur.next = pre.next;
            pre.next = cur;
            
            cur = next;
            pre = dummy;
        }
        
        return dummy.next;
    }
}
