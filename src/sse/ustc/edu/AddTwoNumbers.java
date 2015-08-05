package sse.ustc.edu;

public class AddTwoNumbers {
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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
            
        ListNode l3 = null;
        ListNode p = null;
        ListNode rear = null;
        int carry = 0;
        int sum;
        while(l1 != null && l2 != null)
        {
            sum = l1.val + l2.val + carry;
            if(sum > 9)
                carry = 1;
            else
                carry = 0;
                
            if(carry == 1)
                p = new ListNode(sum - 10);
            else 
                p = new ListNode(sum);
            
            if(l3 != null)
            {
                rear.next = p;
                rear = rear.next;
            }
            else
            {
                l3 = p;
                rear = l3;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        
       
        
        ListNode pnew = null;
        if(l1  == null)
        {
             rear.next = l2;
             p = l2;
             while(p != null)
             {
                 sum = p.val + carry;
                 if(sum > 9)
                 {
                      carry = 1;
                     p.val = sum -10;
                     rear = p;
                     p = p.next;
                 }
                 else
                 {
                     p.val = sum;
                     break;
                 }
                     
             }
             
        }
           
        if(l2 == null)
          {
             rear.next = l1;
             p = l1;
             while(p != null)
             {
                 sum = p.val + carry;
                 if(sum > 9)
                 {
                     carry = 1;
                     p.val = sum -10;
                     rear = p;
                     p = p.next;
                 }
                 else
                 {
                     p.val = sum;
                     break;
                 }
             }
             
        }
        if(p == null && carry == 1)
             {
                   pnew = new ListNode(1);
                   rear.next = pnew;
                   return l3;
             }            
         
          
        return l3;
    }
}
