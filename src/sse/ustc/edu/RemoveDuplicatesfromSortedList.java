package sse.ustc.edu;

public class RemoveDuplicatesfromSortedList {
	 public ListNode deleteDuplicates(ListNode head) {
	        if(head == null || head.next == null)
	            return head;
	        if(head.val == head.next.val)
	            return deleteDuplicates(head.next);
	        head.next = deleteDuplicates(head.next);
	        return head;
	        
	    }
}
