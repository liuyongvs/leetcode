package sse.ustc.edu;

public class ImplementStackusingQueues {
	 //implement stack with two queues
    /**
     *  solution 1:push: always add the element into queue1 
     *             pop:  dequeue the element from queue1 into queue until 1 element left.
     *                   pop the last one and return it
     *                   swap queue1 queue2 
     *  push O(1) pop O(n) peek O(n) 
     */
     
     /**
     *  solution 2: all the element will be reversed in the queue1
     *             push: always add the element into queue2
     *                   poll all the element from queue1 and add into the queue2
     *                   swap queue1 queue2                  
     * 
     *             pop:  dequeue the element from queue1 directly
     *  push O(1) pop O(n) peek O(1) 
     */
  /*   
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        queue1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
        queue1.poll();
        
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Get the top element.
    public int top() {
        while(queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
        int val = queue1.poll();
        queue2.offer(val);
        
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return val;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty();
    }
    
    */
    
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        queue2.add(x);
	    while(!queue1.isEmpty()) {
	       queue2.add(queue1.poll());
	    }
	    Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue1.poll();
    }

    // Get the top element.
    public int top() {
        return queue1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty();
    }
}
