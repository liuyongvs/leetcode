package sse.ustc.edu;

public class ReverseLinkedListII {
	 public ListNode reverse(ListNode head) {
	        if(head == null)
	            return null;
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
	    public ListNode reverseBetween(ListNode head, int m, int n) {
	        if(head == null)
	            return null;
	        ListNode res = head;
	        ListNode preM = null;/* points to the (m - 1)th elment*/
	        ListNode pM = null; /* points to the mth element */
	        ListNode nextN = null;/* points to the (n + 1)th element*/
	        
	        ListNode p = head;
	        int i = 1;
	        while(i < m) {
	            preM = p;
	            p = p.next;
	            i ++;
	        }
	        pM = p;
	        while(i < n) {
	            p = p.next;
	            i ++;
	        }
	        nextN = p.next;
	        p.next = null;/*so the m to n is a list, we can call the function reverse */
	        
	        ListNode rev = reverse(pM);
	        if(preM == null)
	            res = rev;
	        else
	            preM.next = rev;
	            
	        int j = 1;
	        p = res;
	        while(j < n) {
	            p = p.next;
	            j ++;
	        }
	        p.next = nextN;
	        return res;
	    }
}
