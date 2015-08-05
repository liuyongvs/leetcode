package sse.ustc.edu;

public class RemoveElement {
	 public int removeElement(int[] nums, int val) {
	        if(nums.length == 0)
	            return 0;
	        int rear = 0;
	        for(int i = 0; i < nums.length; i ++) {
	            if(nums[i] == val) {
	                continue;
	            }
	            else {
	                nums[rear++] = nums[i];
	            }
	        }
	        
	        return rear;
	        
	    }
}
