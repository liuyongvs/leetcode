package sse.ustc.edu;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        /**add the head node of LinkedList, and finally we should delets it*/
        ListNode l3 = new ListNode(-1);
    //    if(p1.val <= p2.val)
      //      l3 = p1;
    //    else
      //      l3 = p2;
        ListNode p3 = l3;
        while(p1 != null && p2 != null)
        {
            if(p1.val <= p2.val)
            {
                p3.next = p1;
                p1 = p1.next;
              //  next = p1.next;
                
            }
            else
            {
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;
        }
        
        if(p1 == null)
            p3.next = p2;
        if(p2 == null)
            p3.next = p1;
        return l3.next;
    }
	
	ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
            
        ListNode fakeHead = new ListNode(-1);
        ListNode p = fakeHead;
        while(head1 != null && head2 != null) {
            if(head1. val < head2.val) {
                p.next = head1;
                head1 = head1.next;
            }
            else {
                p.next = head2;
                head2 = head2.next;
            }
            
            p = p.next;
        }
        
        if(head1 == null)
            p.next = head2;
        if(head2 == null)
            p.next = head1;
        return fakeHead.next;
    }
}
