package sse.ustc.edu;

public class RemoveNthNodeFromEndofList {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
        ListNode p1 = head;
        ListNode p2 = head;
        while(p1 != null)
        {
            p1 = p1.next;
            n --;
            if(n == 0)
                break;
        }
      //  Given n will always be valid.
      //  if(n > 0)
        //    throw new Exception("ths length of list is less than n");
        ListNode pre = null;
        while(p1 != null)
        {
            pre = p2;
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p2 == head)
        {
            /*if delete the head node */
            head = head.next;
        }
        else
        {
            pre.next = p2.next;
        }
        
        return head;
    }
}
