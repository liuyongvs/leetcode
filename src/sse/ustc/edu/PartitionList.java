package sse.ustc.edu;

public class PartitionList {
	/* we create two list, first small list, second big list, and this way is easy to understand*/
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;
        ListNode small = new ListNode(-1);
        ListNode pres = small;
        ListNode big = new ListNode(-1);
        ListNode preb = big;
        
        ListNode p = head;
        while(p != null) {
            if(p.val < x) {
                pres.next = p;
                pres = p;
            }
            else {
                preb.next = p;
                preb = p;
            }
            p = p.next;
        }
        pres.next = null;
        preb.next = null;
        
        pres.next = big.next;
        return small.next;
    }
}
