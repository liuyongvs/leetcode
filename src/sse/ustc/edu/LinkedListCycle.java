package sse.ustc.edu;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        Set<ListNode> set = new HashSet<>();
        while(head != null) {
            if(!set.contains(head))
                set.add(head);
            else
                return true;
            head = head.next;
        }
        return false;
    }
}
