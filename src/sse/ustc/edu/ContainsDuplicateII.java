package sse.ustc.edu;

public class ContainsDuplicateII {
	 public boolean containsNearbyDuplicate(int[] nums, int k) {
	        HashMap<Integer, Integer> map = new HashMap<>();
	        for(int i = 0; i < nums.length; i ++) {
	            if(map.containsKey(nums[i])) {
	                int index = map.get(nums[i]);
	                int diff = i - index;
	                if(diff <= k)
	                    return true;
	            }
	            /* if has the multiple repeat numbers, such as 2 3 4 5 2 7 2, has three numbers of 2*/
	            map.put(nums[i], i);
	        }
	        
	        return false;
	    }
}
