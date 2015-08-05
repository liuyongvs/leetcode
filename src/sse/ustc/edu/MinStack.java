package sse.ustc.edu;

public class MinStack {
	private Stack<Integer> ministack = new Stack<>();
    private Stack<Integer> s = new Stack<>();
    public void push(int x) {
        s.push(x);
        
        if(ministack.isEmpty() || x < ministack.peek())
            ministack.push(x);
        else
            ministack.push(ministack.peek());
  
        
    }

    public void pop() {
        if(ministack.isEmpty())
            throw new NoSuchElementException("stack underflow");
        ministack.pop();
        s.pop();
    }

    public int top() {
        if(ministack.isEmpty())
            throw new NoSuchElementException("stack underflow");
        return s.peek();
    }

    public int getMin() {
        return ministack.peek();
    }
}
