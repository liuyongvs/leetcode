package sse.ustc.edu;

public class ValidParentheses {
	public boolean isValid(String s) {
	       Stack<Character> stack = new Stack<>();
			char[] arr = s.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
					stack.push(arr[i]);
				}
				else {
					if (stack.isEmpty()) {
						return false;
					}
					char ch = stack.pop();
					if ( (ch == '(' && arr[i] == ')') || 
						 (ch == '[' && arr[i] == ']') || 
						 (ch == '{' && arr[i] == '}')) {
						
					}
					else {
						return false;
					}
				}
			}
			
			if (stack.isEmpty()) {
				return true;
			}
			return false;
	    }
}
