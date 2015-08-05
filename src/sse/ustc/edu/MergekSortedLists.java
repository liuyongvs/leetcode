package sse.ustc.edu;

public class MergekSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
        //here can't be if(lists == null), we use the 0-length array in java instead of use null to avoid checking the input array is null
        if(lists.length == 0)
            return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(ListNode x: lists) {
            if(x != null)
                queue.offer(x);
        }
        
        ListNode res = new ListNode(-1);
        ListNode p = res;
        while(!queue.isEmpty()) {
            ListNode top = queue.poll();
            p.next = top;
            p = p.next;
            if(top.next != null)
                queue.add(top.next);
        }
        
        return res.next;
    }
}
