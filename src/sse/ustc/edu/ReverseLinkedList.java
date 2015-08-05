package sse.ustc.edu;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode pre = null;
        ListNode p = head;
        while(p != null) {
            ListNode r = p.next;
            p.next = pre;
            pre = p;
            p = r;
        }
        head = pre;
        return head;
    }
	
	
}
