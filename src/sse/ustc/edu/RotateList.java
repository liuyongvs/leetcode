package sse.ustc.edu;

public class RotateList {
	 /* the k can be arbitrary. we just need to process between 0 and k - 1 */
	 public int getLength(ListNode head) {
	        if(head == null)
	            return 0;
	        int len = 0;
	        ListNode p =head;
	        while(p != null) {
	            p = p.next;
	            len ++;
	        }
	        return len;
	    }
	    public ListNode rotateRight(ListNode head, int k) {
	        if(head == null)
	            return null;
	        int len = getLength(head);
	        k = k % len;
	        if(k == 0)
	            return head;
	        ListNode p1 = head;
	        ListNode p2 = head;
	        while(p1 != null) {
	            p1 = p1.next;
	            k --;
	            if(k == 0)
	                break;
	        }
	        
	        while(p1.next != null) {
	            p1 = p1.next;
	            p2 = p2.next;
	        }
	        ListNode res = p2.next;
	        p2.next = null;
	        p1.next = head;
	        return res;
	    }
}
