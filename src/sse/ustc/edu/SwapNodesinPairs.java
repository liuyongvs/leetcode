package sse.ustc.edu;

public class SwapNodesinPairs {
	/* the recursive approach, easy to understand*/
	 public ListNode swapPairs(ListNode head) {
	        if(head == null || head.next == null)
	            return head;
	        ListNode res = head.next;
	        ListNode next = res.next;
	        res.next = head;
	        head.next = swapPairs(next);
	        return res;
	    }
	
	 /*every two node to link the node*/
    public ListNode swapPairs(ListNode head) {
       if(head == null || head.next == null)
            return head;
       ListNode dummy = new ListNode(-1);
       dummy.next = head;
       ListNode pre = dummy;
       ListNode p = head;
       ListNode next = null;
       while(p != null && p.next != null) {
           next = p.next.next;
           pre.next = p.next;
           p.next.next = p;
           p.next = next;
           pre = p;
           p = next;
       }
       
       return dummy.next;
    }
}
