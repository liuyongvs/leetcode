package sse.ustc.edu;

public class DeleteNodeinaLinkedList {
	public void deleteNode(ListNode node) {
        if(node == null)
            return;
        ListNode next = node.next;
        node.next = node.next.next;
        
        int temp = next.val;
        next.val = node.val;
        node.val = temp;
    }
}
