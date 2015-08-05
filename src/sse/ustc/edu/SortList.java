package sse.ustc.edu;

public class SortList {
	public ListNode splitList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p1 = head;
        ListNode p2 = head;
        while(p1.next != null && p1.next.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
        }

        ListNode newHead = p2.next;
        p2.next = null;
        return newHead;
    }
    
    public ListNode mergeList(ListNode head1, ListNode head2) {
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        ListNode res = null;
        if(head1.val < head2.val) {
            res = head1;
            res.next = mergeList(head1.next, head2);
        }
        else {
            res = head2;
            res.next = mergeList(head1, head2.next);
        }
        return res;
    }
    
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode head1 = head;
        ListNode head2 = splitList(head);
      //  head1 = sortList(head1);
    //    head2 = sortList(head2);
     //   return mergeList(head1, head2);
        return mergeList(sortList(head1), sortList(head2));
    }
}
