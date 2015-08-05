package sse.ustc.edu;

public class ReorderList {
   /*three steps: first break the list into two parts, second reverse the second list, third merge list*/
    
    public ListNode getMiddle(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p1 = head;
        ListNode p2 = head;
        while(p1.next != null && p1.next.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
        }
        
        return p2;
    }
    
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode p = head;
        ListNode next = null;
        while(p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
    
    public ListNode mergeList(ListNode head1, ListNode head2) {
       if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1 != null && p2 != null) {
			p.next = p1;
			p1 = p1.next;
			p = p.next;
			
			p.next = p2;
			p2 = p2.next;
			p = p.next;
        }
        
        if (p1 == null) {
			p.next = p2;
		}
        if (p2 == null) {
			p.next = p1;
		}
        return dummy.next;
    }
    

    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode first = head;
        ListNode mid = getMiddle(head);
        ListNode second = mid.next;
        mid.next = null;
        
        
        second = reverse(second);
        head = mergeList(first, second);
    }
}
