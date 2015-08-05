package sse.ustc.edu;
//if we want to know whether the list has the inserction, we just need to check whether the last of two list node is same 
/* solution1: brute force  O(n*m)*/
/* solution2 :hash table O(n + m), but need O(n) space complexity*/
/* solution3: two pointer, we need get the length of list */
/* solution4: we can make the list to be a circle, then use the approach to find the begin node of circle*/
public class IntersectionofTwoLinkedLists {
	public int getLength(ListNode head) {
        if(head == null)
            return 0;
        int count = 0;
        ListNode p = head;
        while(p != null) {
            count ++;
            p = p.next;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
            
        int len1 = getLength(headA);
        int len2 = getLength(headB);
        
        ListNode p1 = null;
        ListNode p2 =null;
        int diff = len1 - len2;
        if(diff > 0) {
            p1 = headA;
            p2 = headB;
        }
        else {
            p1 = headB;
            p2 = headA;
            diff = -diff;
            
        }
        
        while(diff > 0) {
            p1 = p1.next;
            diff --;
        } 
            
        while(p1 != null) {
            if(p1 == p2)
                return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
