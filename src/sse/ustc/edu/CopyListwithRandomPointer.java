package sse.ustc.edu;

public class CopyListwithRandomPointer {
	/*we do it with three steps.*/
    /* first copy the list, A->A'->B->B'->C->C'..., second modify the random pointer. second break the list into two parts*/
    
    public void copyList(RandomListNode head) {
        if(head == null)
            return;
        RandomListNode p = head;
        RandomListNode next = null;
        while(p != null) {
            RandomListNode q = new RandomListNode(p.label);
            next = p.next;
            p.next = q;
            q.next = next;
            p = next;
        }
    }
    
    public void modifyRandom(RandomListNode head) {
        if(head == null)
            return;
        RandomListNode p = head;
        while(p != null) {
            RandomListNode q = p.next;
            if(p.random != null)
                q.random = p.random.next;
            p = q.next;
            
        }
    }
    
    public RandomListNode splitList(RandomListNode head) {
        if(head == null)
            return null;
        
        RandomListNode res = head.next;
        RandomListNode p = head;
       
        while(p != null) {
            RandomListNode q = p.next;
            p.next = q.next;
            p = p.next;
            if(p != null)
                q.next = p.next;
        }
        return res;
    }
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        copyList(head);
        modifyRandom(head);
        return splitList(head);
    }
}
