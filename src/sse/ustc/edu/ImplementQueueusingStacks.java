package sse.ustc.edu;

public class ImplementQueueusingStacks {
	//implement queue with stack
	/**
	 * 
	 * @author jacky
	 *	solutin 1: use two stacks
	 *	enqueue: add the element on the top stack1
	 *	dequeue:  
	 *		1) if both stacks are empty, throw exception
	 *		2) if stack2 is empty
	 *			 pop all the stack1 into stack 2
	 *		3)  pop the element from stack2 and return it
	 */
	 
	 /*
	    private Stack<Integer> s1 = new Stack<>();
		private Stack<Integer> s2 = new Stack<>();
		
	    // Push element x to the back of queue.
	    public void push(int x) {
	        s1.add(x);
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	        if (s2.isEmpty()) {
//				if (s1.isEmpty()) {
//					throw new Exception("stack underflow");
//				}
				while (!s1.isEmpty()) {
					s2.add(s1.pop());
				}
			}
			s2.pop();
	    }

	    // Get the front element.
	    public int peek() {
	        if (s2.isEmpty()) {
				while (!s1.isEmpty()) {
					s2.add(s1.pop());
				}
			}
			return s2.peek();
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	        return s1.isEmpty() && s2.isEmpty();
	    }
	    
	    */
	    
	    
	    //implemet queue with one stack
	    private Stack<Integer> s = new Stack<>();

		
	    // Push element x to the back of queue.
	    public void push(int x) {
	        s.add(x);
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	        if(s.size() == 1) {
	            s.pop();
	            return;
	        }
	        int val = s.pop();
	        pop();
	        s.push(val);
	    }

	    // Get the front element.
	    public int peek() {
	        if(s.size() == 1) {
	            return s.peek();
	        }
	        int val = s.pop();
	        int res = peek();
	        s.push(val);
	        return res;
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	        return s.isEmpty();
	    }
}
