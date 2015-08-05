package sse.ustc.edu;

public class PalindromeLinkedList {
    //solution 1: we can use the data struct to store the elements, such as stack
    //solution 2: find the middle, break the list into two parts
        //        reverse the second part
        //        reconstruct the original list
    
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
    
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p = head;
        ListNode pre = null;
        ListNode next = null;
        while(p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
    
    public boolean isPalindromeHelper(ListNode head1, ListNode head2) {
        if(head1 == null && head2 == null)
            return true;
            
        while(head1 != null && head2 != null) {
            if(head1.val != head2.val)
                return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next ==null)
            return true;
        
        ListNode mid = getMiddle(head);
        ListNode head2 = mid.next;
        mid.next = null;
        
        ListNode revList = reverseList(head2);
        boolean res = isPalindromeHelper(head, revList);
        
        //reconstruct the original list
        head2 = reverseList(revList);
        mid.next = head2;
        return res;
        
    }
}
