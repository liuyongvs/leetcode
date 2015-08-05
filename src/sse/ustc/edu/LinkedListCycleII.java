package sse.ustc.edu;

public class LinkedListCycleII {
	 public ListNode detectCycle(ListNode head) {
	        if(head == null)
	            return null;
	        ListNode p1 = head;
	        ListNode p2 = head;
	        while(p1 != null && p1.next != null) {
	            p1 = p1.next.next;
	            p2 = p2.next;
	            if(p1 == p2)
	                break;
	        }
	        
	        if(p1 == null || p1.next == null)
	            return null;
	     //   if(p1 == p2) {
	        p1 = head;
	        while(p1 != p2) {
	            p1 = p1.next;
	            p2 = p2.next;
	        }
	        return p1;
	       // }
	    }
}
